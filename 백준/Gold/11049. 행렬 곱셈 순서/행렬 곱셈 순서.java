import java.io.*;
import java.util.*;

public class Main {
	static long[][] dp;
	static int[] nums;
	static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    dp = new long[N+1][N+1];
	    nums = new int[N+1];
	    for(int i = 0; i < N; i++) {
	    	StringTokenizer st = new StringTokenizer((br.readLine()));
	    	for (int j = 0; j < 2; j++) {
	    		Integer tmp = Integer.parseInt(st.nextToken());
	    		nums[i+j] = tmp;
	    	}
	    }
	    int len = 2;
	    for (int i = 0; i < N-1; i++) {
	    	dp[i][i+len] = (long) nums[i]*nums[i+1]*nums[i+2];
	    }
	    
	    for (len = 3; len < N+1; len++) {
	    	for (int i = 0; i <= N - len; i++) {
	    		int j = i+len;
	    		dp[i][j] = max;
	    		int sum = nums[i]*nums[j];
	    		for (int m = i+1; m < j ; m++) {
	    			long val = dp[i][m] + dp[m][j] + sum*nums[m];
	    			if (dp[i][j] > val) {
	    				dp[i][j] = val;
	    			}
	    		}
	    	}
	    }
	    System.out.println(dp[0][N]);
    }
}