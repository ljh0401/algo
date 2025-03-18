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
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Map<Integer, List<int[]>> map = new HashMap<>();
		for (int i = 0; i< E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (!map.containsKey(start)) {
				map.put(start, new ArrayList<>());
			}
			if (!map.containsKey(end)) {
				map.put(end, new ArrayList<>());
			}
			map.get(start).add(new int[] {end, c});
			map.get(end).add(new int[] {start, c});
		}
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		boolean[] V11 = new boolean[N+1];
		PriorityQueue<int[]> pq1 = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		int[] V1 = new int[N+1];
		Arrays.fill(V1, Integer.MAX_VALUE);
		pq1.add(new int[] {v1, 0});
		V1[v1] = 0;
		while(!pq1.isEmpty()) {
			int tmp = pq1.poll()[0];
			if (V11[tmp]) continue;
			
			V11[tmp] = true;
			if (!map.containsKey(tmp)) continue;
			List<int[]> list = map.get(tmp);
			for (int i = 0; i < list.size(); i++) {
				int end = list.get(i)[0];
				int c = list.get(i)[1];
				if (V1[end] > V1[tmp]+c) {
					V1[end] = V1[tmp]+c;
					pq1.add(new int[] {end, V1[end]});
				}
			}
		}
		
		boolean[] V22 = new boolean[N+1];
		PriorityQueue<int[]> pq2 = new PriorityQueue<>((a, b) -> a[1]-b[1]);
		int[] V2 = new int[N+1];
		Arrays.fill(V2, Integer.MAX_VALUE);
		pq2.add(new int[] {v2, 0});
		V2[v2] = 0;
		while(!pq2.isEmpty()) {
			int tmp = pq2.poll()[0];
			if (V22[tmp]) continue;
			
			V22[tmp] = true;
			if (!map.containsKey(tmp)) continue;
			List<int[]> list = map.get(tmp);
			for (int i = 0; i < list.size(); i++) {
				int end = list.get(i)[0];
				int c = list.get(i)[1];
				if (V2[end] > V2[tmp]+c) {
					V2[end] = V2[tmp]+c;
					pq2.add(new int[] {end, V2[end]});
				}
			}
		}
		int answer;
		if ((V1[1] == Integer.MAX_VALUE || V2[N] == Integer.MAX_VALUE) && (V2[1] == Integer.MAX_VALUE || V1[N] == Integer.MAX_VALUE)) {
			answer = -1;
		} else if (V1[v2] == Integer.MAX_VALUE || (V1[1] == Integer.MAX_VALUE && V2[N] == Integer.MAX_VALUE) || (V2[1] == Integer.MAX_VALUE && V1[N] == Integer.MAX_VALUE)) {
			answer = -1;
		} else {
			answer = Math.min(V1[1] + V2[N], V1[N] + V2[1]);
			answer += V1[v2];
		}
		System.out.print(answer);
	}
}