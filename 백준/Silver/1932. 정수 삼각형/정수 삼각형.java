import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n*(n+1)/2];
		int tmp = Integer.parseInt(br.readLine());
		nums[0] = tmp;
		tmp = 1;
		for (int i = 1; i < n; i++) {
			int num = tmp-i;
			StringTokenizer st = new StringTokenizer(br.readLine());
			nums[tmp] = nums[num] + Integer.parseInt(st.nextToken());
			tmp++;
			for (int j = 1; j < i; j++) {
				nums[tmp++] = Math.max(nums[num], nums[++num])+Integer.parseInt(st.nextToken());
			}
			nums[tmp++] = nums[num] + Integer.parseInt(st.nextToken());
		}
		int answer = nums[(n*n-n)/2];
		for (int i =(n*n-n)/2; i<n*(n+1)/2; i++) {
			if (nums[i] > answer)
				answer = nums[i];
		}
		System.out.println(answer);
	}
}
