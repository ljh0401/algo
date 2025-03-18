import java.io.*;
import java.util.*;

public class Main {
	static boolean[] vis;
	
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    StringBuilder sb = new StringBuilder();
	    while(n != 0) {
		    long max = 0;
		    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[0]-a[0])==0 ? a[1] - b[1] : b[0]-a[0]);
		    pq.add(new int[] {0, -1});
		    for (int i = 0; i < n; i++ ) {
		    	int num = Integer.parseInt(st.nextToken());
		    	if (pq.peek()[0] > num) {
		    		int min = n;
		    		while(pq.peek()[0] > num) {
		    			int[] tmp = pq.poll();
		    			long cal = (long) tmp[0]*(i - tmp[1]);
		    			min = min > tmp[1] ? tmp[1] : min;
		    			max = max < cal ? cal : max;
		    		}
		    		pq.add(new int[] {num, min});
		    	} else if (pq.peek()[0] < num) {
		    		pq.add(new int[] {num, i});
		    	}
		    }
		    while(!pq.isEmpty()) {
	    		int[] tmp = pq.poll();
	    		long cal = ((long) tmp[0])*(n - tmp[1]);
	    		max = max < cal ? cal : max;
		    }
		    sb.append(max+"\n");
		    st = new StringTokenizer(br.readLine());
		    n = Integer.parseInt(st.nextToken());
	    }
	    
	    System.out.print(sb);
	}
}