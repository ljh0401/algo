import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1] > 0) ? 1:-1 );
	    for (int i = 0; i < n; i++) {
	    	pq.add(new long[] {i, Long.parseLong(st.nextToken())});
	    }
	    long tmp = Long.MAX_VALUE;
	    int size = -1;
	    int[] answer = new int[n];
	    for (int i = 0; i < n; i++) {
	    	long[] cur = pq.poll();
	    	if (tmp == cur[1]) {
	    		answer[(int) cur[0]] = size;
	    	} else {
	    		size += 1;
	    		answer[(int) cur[0]] = size;
	    		tmp = cur[1];
	    	}
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < n; i++) {
	    	sb.append(answer[i]+" ");
	    }
	    System.out.print(sb);
    }   	
}
