import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	int n = Integer.parseInt(st.nextToken());
        	int m = Integer.parseInt(st.nextToken());
        	int t = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int g = Integer.parseInt(st.nextToken());
        	int h = Integer.parseInt(st.nextToken());
        	HashMap<Integer, List<int[]>> map = new HashMap<>();
        	int id = 0;
        	int fix = -1;
        	for (int i = 0; i < m; i++) {
        		st = new StringTokenizer(br.readLine());
            	int a = Integer.parseInt(st.nextToken());
            	int b = Integer.parseInt(st.nextToken());
            	int d = Integer.parseInt(st.nextToken());
            	if (!map.containsKey(a)) {
            		map.put(a, new ArrayList<>());
            		}
            	if (!map.containsKey(b)) {
            		map.put(b, new ArrayList<>());
            		}
            	map.get(a).add(new int[] {b, d, id});
            	map.get(b).add(new int[] {a, d, id});
            	if ((a == g && b == h) || (b == g && a == h)) fix = id;
            	id++;
        	}
        	PriorityQueue<Integer> des = new PriorityQueue<>();
        	for (int i = 0 ;i < t; i++) {
        		st = new StringTokenizer(br.readLine());
        		des.add(Integer.parseInt(st.nextToken()));
        	}
        	boolean[] vis = new boolean[n+1];
        	boolean[] str = new boolean[n+1];
        	int[] dis = new int[n+1];
        	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        	pq.add(new int[] {s, 0});
        	while(!pq.isEmpty()) {
        		int[] cur = pq.poll();
        		if (vis[cur[0]]) continue;
        		vis[cur[0]] = true;
        		int low = cur[0];
        		for (int[] tmp : map.get(low)) {
        			int end = tmp[0];
        			if (vis[end]) continue;
        			int distance = tmp[1];
        			if (dis[end] == 0) {
        				int nId = tmp[2];
        				dis[end] = dis[low]+distance;
        				pq.add(new int[] {end, dis[end]});
        				if (nId == fix) str[end] = true;
        				else str[end] = str[low];
        			}
        			else if (dis[low]+distance < dis[end]) {
        				int nId = tmp[2];
        				dis[end] = dis[low]+distance;
        				pq.add(new int[] {end, dis[end]});
        				if (nId == fix) str[end] = true;
        				else str[end] = str[low];
        			} else if (dis[low]+distance == dis[end]) {
        				if (!str[end]) {
        					int nId = tmp[2];
        					if (nId == fix) str[end] = true;
            				else str[end] = str[low];
        				}
        			}
        		}
        	}
        	while(!des.isEmpty()) {
        		int ca = des.poll();
        		if (str[ca]) sb.append(ca+" ");
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
    }
}
