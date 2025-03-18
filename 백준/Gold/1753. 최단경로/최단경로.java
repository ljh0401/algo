import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int MAX = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			if (!map.containsKey(v1)) map.put(v1, new HashMap<>());
			if (!map.get(v1).containsKey(v2)) {
				map.get(v1).put(v2, w);
			} else {
				if (map.get(v1).get(v2) > w) map.get(v1).put(v2, w);
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		boolean[] bv = new boolean[V+1];
		int[] dis = new int[V+1];
		Arrays.fill(dis, MAX);
		dis[start] = 0;
		pq.add(new int[] {start, 0});
		while(!pq.isEmpty()) {
			int[] tmp = pq.poll();
			if (!map.containsKey(tmp[0]) || bv[tmp[0]]) continue;
			Map<Integer, Integer> newMap = map.get(tmp[0]);
			Object[] keys = newMap.keySet().toArray();
			bv[tmp[0]] = true;
			for (int i = 0; i < keys.length; i++) {
				int num = (int) keys[i];
				if (dis[num] > dis[tmp[0]] + newMap.get(num)) {
					dis[num] = dis[tmp[0]] + newMap.get(num);
					pq.add(new int[] {num, dis[num]});
				}				
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < V+1; i++) {
			if (dis[i] == MAX) {
				sb.append("INF\n");
			} else {				
				sb.append(dis[i]+"\n");
			}
		}
		System.out.print(sb);
	}
}