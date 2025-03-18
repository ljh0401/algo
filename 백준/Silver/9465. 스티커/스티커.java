import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int[][] nums = new int[3][n];
			nums[0][0] = Integer.parseInt(st1.nextToken());
			nums[1][0] = Integer.parseInt(st2.nextToken());
			nums[2][0] = 0;
			for (int j =1; j < n; j++) {
				nums[0][j] = Math.max(nums[1][j-1], nums[2][j-1])+Integer.parseInt(st1.nextToken());
				nums[1][j] = Math.max(nums[0][j-1], nums[2][j-1])+Integer.parseInt(st2.nextToken());
				nums[2][j] = Math.max(nums[0][j-1], nums[1][j-1]);
			}
			int answer = Math.max(nums[2][n-1], Math.max(nums[0][n-1], nums[1][n-1]));
			sb.append(answer+"\n");
		}
		
		System.out.print(sb);
	}
}
