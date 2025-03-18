import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int nums[][] = new int[n][n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			if (i == 0) {
				nums[0][i] = Integer.parseInt(st.nextToken());
			}
			else {
				nums[0][i] = nums[0][i-1] + Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				if (j == 0) {
					 nums[i][j] = nums[i-1][j] + Integer.parseInt(st.nextToken());
				}
				else {
					nums[i][j] = nums[i-1][j] + nums[i][j-1] + Integer.parseInt(st.nextToken()) - nums[i-1][j-1];
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken()) - 1;
			int y1 = Integer.parseInt(st.nextToken()) - 1;
			int x2 = Integer.parseInt(st.nextToken()) - 1;
			int y2 = Integer.parseInt(st.nextToken()) - 1;
			int answer = 0;
			if (x1 == 0 && y1 == 0) {
				answer = nums[x2][y2];
			}
			else if (x1 == 0) {
				answer = nums[x2][y2] - nums[x2][y1-1];
			}
			else if (y1 == 0) {
				answer = nums[x2][y2] - nums[x1-1][y2];
			}
			else {
				answer = nums[x2][y2] - nums[x2][y1-1] - nums[x1-1][y2] + nums[x1-1][y1-1] ;
			}
			sb.append(answer + "\n");
		}
		
		System.out.print(sb);
	}
}
