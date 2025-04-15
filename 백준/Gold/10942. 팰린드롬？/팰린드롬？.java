import java.io.*;
import java.util.*;

public class Main {
	static int[] nums;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    nums = new int[n];
	    for (int i = 0; i < n; i++) {
	    	nums[i] = Integer.parseInt(st.nextToken());
	    }
	    int m = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < m; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	int x = Integer.parseInt(st.nextToken()) - 1;
	    	int y = Integer.parseInt(st.nextToken()) - 1;
	    	while(true) {
	    		if (nums[x] == nums[y]) {
	    			if (x == y || y - x == 1) {
	    				sb.append(1+"\n");
	    				break;
	    			}
	    			x += 1;
	    			y -= 1;
	    		} else {
	    			sb.append(0+"\n");
	    			break;
	    		}
	    	}
	    }
	    System.out.print(sb);
    }
}