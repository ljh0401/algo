import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int nums[][] = new int[n+1][6];
		int max1;
		int max2;
		int max3;
		int min1;
		int min2;
		int min3;
		for (int i = 1; i<n+1; i++) {
			st = new StringTokenizer(br.readLine());
			max1 = nums[i-1][0] >= nums[i-1][1] ? nums[i-1][0]:nums[i-1][1];
			max3 = nums[i-1][1] >= nums[i-1][2] ? nums[i-1][1]:nums[i-1][2];
			max2 = max1 >= max3 ? max1:max3;
			min1 = nums[i-1][3] >= nums[i-1][4] ? nums[i-1][4]:nums[i-1][3];
			min3 = nums[i-1][4] >= nums[i-1][5] ? nums[i-1][5]:nums[i-1][4];
			min2 = min1 >= min3 ? min3:min1;
			int one = Integer.parseInt(st.nextToken());
			int two = Integer.parseInt(st.nextToken());
			int three = Integer.parseInt(st.nextToken());
			nums[i][0] = max1 + one;
			nums[i][1] = max2 + two;
			nums[i][2] = max3 + three;
			nums[i][3] = min1 + one;
			nums[i][4] = min2 + two;
			nums[i][5] = min3 + three;
		}
		int max = Math.max(nums[n][0],Math.max(nums[n][1], nums[n][2]));
		int min = Math.min(nums[n][3],Math.min(nums[n][4], nums[n][5]));
		System.out.print(max+" "+min);
	}
}