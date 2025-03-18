
import java.util.*;

public class Solution {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for (int test = 1; test <= T; test++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			int[] nums = new int[V+1];
			Map<Integer, List<Integer>> map = new HashMap<>();
			for (int i = 0; i < E; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				List<Integer> list = map.getOrDefault(start, new ArrayList<>());
				list.add(end);
				nums[end] += 1;
				map.put(start, list);
			}
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i < V+1; i++) {
				if(nums[i] == 0) {
					queue.add(i);
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append('#');
			sb.append(test);
			while(!queue.isEmpty()) {
				int num1 = queue.poll();
				sb.append(' ');
				sb.append(num1);
				if (!map.containsKey(num1)) continue;
				for (int num : map.get(num1)) {
					nums[num] -= 1;
					if (nums[num] == 0) {
						queue.add(num);
					}
				}
			}
			System.out.println(sb);
		}
	}
}