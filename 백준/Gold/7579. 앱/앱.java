import java.io.*;
import java.util.*;

public class Main {
	static int[] mem, cost;
	static int[] costDp;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    StringTokenizer st1 = new StringTokenizer(br.readLine());
	    mem = new int[n];
	    cost = new int[n];
	    costDp = new int[10001];
	    Arrays.fill(costDp, -1);
	    costDp[0] = 0;
	    for(int i = 0; i < n; i++) {
	    	mem[i] = Integer.parseInt(st.nextToken());
	    	cost[i] = Integer.parseInt(st1.nextToken());
	    	int cl = cost[i];
	    	for (int j = 10000; j >= cl; j--) {
	    		if (costDp[j-cl] == -1) continue;
	    		if (costDp[j] == -1) costDp[j] = costDp[j-cl]+ mem[i];
	    		else {
	    			costDp[j] = Math.max(costDp[j], costDp[j-cl]+ mem[i]);
	    		}
	    	}
	    }
	    int answer = 100001;
	    for (int i = 0; i < 10001; i++) {
	    	if (costDp[i] == -1) continue;
	    	if (costDp[i] >= m) {
	    	answer = i;
	    	break;
	    	}
	    }
	    System.out.print(answer);
    }
}