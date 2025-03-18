
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test = 1; test <= T;test++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			Map<Integer, List<Integer>> map = new HashMap<>();
			Queue<Integer> queue = new LinkedList<>();
			int[] river = new int[M+1];
			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int first = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if (map.containsKey(first)) {
					map.get(first).add(end);
				}
				else {
					map.put(first, new ArrayList<>());
					map.get(first).add(end);
				}
				river[end] += 1;
			}
			int answer = 1;
			Map<Integer, List<Integer>> str = new HashMap<>();
			for (int i = 1; i <= M; i++) {
				if (river[i] == 0) {
					queue.add(i);
					str.put(i, new ArrayList<>(1));
					str.get(i).add(1);
				}
			}
			while(!queue.isEmpty()) {
				int num = queue.poll();
				int good = find(str.get(num));
				if (num == M) {
					answer = good;
					break;
				}
				for (int tmp : map.get(num)) {
					river[tmp] -= 1;
					if (str.containsKey(tmp)) {
						str.get(tmp).add(good);
					}
					else {
						str.put(tmp, new ArrayList<>());
						str.get(tmp).add(good);
					}
					if (river[tmp] == 0) {
						queue.add(tmp);
					}
				}					
			}
			System.out.println(K+" "+answer);
		}
	}

	static int find(List<Integer> good) {
		int max = 1;
		int count = 0;
		for (int i : good) {
			if (max < i) {
				max = i;
				count = 1;
			}
			else if (max == i) {
				count += 1;
			}
		}
		
		if (count > 1) {
			return max+1;
		}
		return max;
	}
}