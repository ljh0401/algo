import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[] dp = new int[50001];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
        dp[1] = 1;
 
        int min = 0;
        for (int i = 2; i <= num; i++) {
            min = 4;
            for (int j = 1; j * j <= i; j++) {
                int temp = i - j * j;
                min = Math.min(min, dp[temp]);
            }
 
            dp[i] = min + 1;
        }
		System.out.println(dp[num]);
	}
}