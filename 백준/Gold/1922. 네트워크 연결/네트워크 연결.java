import java.io.*;
import java.util.*;

public class Main {
	static boolean[] vis;
	
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    Map<Integer, List<int[]>> list = new HashMap<>();
	    for (int i = 0; i < m; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	int c = Integer.parseInt(st.nextToken());
	    	if (!list.containsKey(a)) {
	    		list.put(a, new ArrayList<>());
	    	}
	    	if (!list.containsKey(b)) {
	    		list.put(b, new ArrayList<>());
	    	}
	    	list.get(a).add(new int[] {b, c});
	    	list.get(b).add(new int[] {a, c});
	    }
	    int cnt = 1;
	    int answer = 0;
	    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
	    vis = new boolean[n+1];
	    vis[1] = true;
	    for (int[] t : list.get(1)) {
	    	pq.add(t);
	    }
	    while (cnt < n) {
	    	int[] tmp = pq.poll();
	    	if (!vis[tmp[0]]) {
	    		vis[tmp[0]] = true;
	    		answer += tmp[1];
	    		cnt += 1;
	    		for (int[] t : list.get(tmp[0])) {
	    	    	pq.add(t);
	    	    }
	    	}
	    }
	    System.out.println(answer);
	}
}
