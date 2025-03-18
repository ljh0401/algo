import java.util.*;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			Map<Integer, List<Integer>> map = new HashMap<>();
            sc.nextLine();
            
			for(int i = 0; i < M; i++) {
                int K = sc.nextInt();
                int next = sc.nextInt();
				if(map.containsKey(K)) map.get(K).add(next);
                else {
                	map.put(K, new ArrayList<>());
                    map.get(K).add(next);
                }
                if(map.containsKey(next)) map.get(next).add(K);
                else {
                	map.put(next, new ArrayList<>());
                    map.get(next).add(K);
                }
			}
			boolean[] v = new boolean[N+1];
			Queue<Integer> queue = new LinkedList<>();
			int answer = 0;
			for (int key : map.keySet()) {
				if(v[key]) {
					continue;
				}
                v[key] = true;
				List<Integer> li = map.get(key);
				for (int i = 0; i < li.size(); i++) {
					int num = li.get(i);
					if (!v[num]) {
						queue.add(num);
					}
				}
                
				while(!queue.isEmpty()) {
					int tmp = queue.poll();
                    if (v[tmp]) continue;
                    v[tmp] = true;
                    if (map.containsKey(tmp)) {
                        List<Integer> L = map.get(tmp);
                        for (int i = 0; i < L.size(); i++) {
                            int NUM = L.get(i);
                            if (v[NUM]) continue;
                            queue.add(NUM);
                        }
                    }
				}
				answer += 1;
			}
			for (int i = 0; i < N+1; i++) {
				if (!v[i]) answer += 1;
			}
            answer -= 1;
			System.out.println("#"+test+" "+answer);
		}
	}
}