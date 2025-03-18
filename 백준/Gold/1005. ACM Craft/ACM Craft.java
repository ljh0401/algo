
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test<= T; test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			Map<Integer, List<Integer>> map = new HashMap<>();
			int[] time = new int[N+1];
			int[] build = new int[N+1];
			int[] max = new int[N+1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (!map.containsKey(start)) {
					map.put(start, new ArrayList<>());
					map.get(start).add(end);
				}
				else {
					map.get(start).add(end);
				}
				build[end] += 1;
			}
			Queue<int[]> queue = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (build[i] == 0) {
					queue.add(new int[] {i, time[i]});					
				}
			}
			int answer = 0;
			int W = Integer.parseInt(br.readLine());
			while(!queue.isEmpty()) {
				int[] tmp = queue.poll();
				if (tmp[0] == W) {
					answer = tmp[1];
					break;
				}
				if (!map.containsKey(tmp[0])) {
					continue;
				}
				for (int t : map.get(tmp[0])) {
					build[t] -= 1;
					if (max[t] < tmp[1]) {
						max[t] = tmp[1];
					}
					if (build[t] == 0) {
						queue.add(new int[] {t, max[t]+time[t]});
					}
				}
			}
			System.out.println(answer);
		}
	}
}
