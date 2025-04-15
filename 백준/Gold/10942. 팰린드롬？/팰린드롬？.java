import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
	static boolean[][] dp;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    nums = new int[n];
	    dp = new boolean[n][n];
	    for (int i = 0; i < n; i++) {
	    	nums[i] = Integer.parseInt(st.nextToken());
	    }
	    for (int i = 0; i < n; i++) {
	    	dp[i][i] = true;
	    }
	    for (int i = 0; i < n-1; i++) {
	    	if (nums[i] == nums[i+1]) dp[i][i+1] = true;
	    }
	    for (int len = 2; len < n; len++) {
    		for (int i = 0; i < n-len; i++) {
	    		if (!dp[i+1][i+len-1]) continue;
	    		if (nums[i] == nums[i+len]) dp[i][i+len] = true;
	    	}
	    }
	    int m = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < m; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken()) - 1;
	    	int y = Integer.parseInt(st.nextToken()) - 1;
	    	if (dp[x][y]) {
	    		sb.append(1+"\n");
	    	} else {
	    		sb.append(0+"\n");
	    	}
	    }
	    System.out.print(sb);
    }
}