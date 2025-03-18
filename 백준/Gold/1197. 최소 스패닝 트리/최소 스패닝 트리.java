import java.io.*;
import java.util.*;

public class Main {
	static int[] union;
	
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    int v = Integer.parseInt(st.nextToken());
	    int e = Integer.parseInt(st.nextToken());
	    union = new int[v+1];
	    for (int i = 1; i < v+1; i++) {
	    	union[i] = i;
	    }
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
	    for (int i = 0; i < e; i++) {
	    	st = new StringTokenizer(br.readLine());
	    	pq.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
	    }
	    int[] tmp = pq.poll();
	    int answer = 0;
	    if (v == 1) {
	    	answer = 0;
	    } else {
	    	answer = tmp[2];
	    	int size = 2;
	    	union[tmp[1]] = tmp[0];
	    	while(size < v) {
	    		tmp = pq.poll();
	    		if (findF(tmp[1]) == findF(tmp[0])) {
	    			continue;
	    		} 
	    		union[union[tmp[1]]] = tmp[0];
	    		answer += tmp[2];
	    		size++;
	    	}
	    }
	    
	    System.out.println(answer);
    }
    
    public static int findF(int n) {
    	if (union[n] == n) {
    		return n;
    	}
    	
    	union[n] = findF(union[n]);
    	return union[n];
    }
}
