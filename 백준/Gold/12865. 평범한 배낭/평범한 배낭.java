import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[] dp = new int[W+1];
		for (int i = 0; i< N; i++ ) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			if (w <= W) {
				for (int j = W; j >= w; j-- ) {
					int max = Math.max(dp[j-1], dp[j-w]+v);
					dp[j] = Math.max(max, dp[j]);
				}
			}
		}
		System.out.print(dp[W]);
	}
}