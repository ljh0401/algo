import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<Integer, List<int[]>> pa, ch;
	static int n, max;
	static int[] dis;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		if (n == 1) {
			System.out.print(0);
		}
		else {
			pa = new HashMap<>();
			for (int i = 0; i < n-1; i++) {
				st = new StringTokenizer(br.readLine());
				int P = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				int W = Integer.parseInt(st.nextToken());
				if (!pa.containsKey(P))
					pa.put(P, new ArrayList<>());
				pa.get(P).add(new int[] {C, W});
				
			}
			max = 0;
			dfs(1);
			System.out.print(max);
		}
	}
	
	public static int dfs(int node) {
		if (!pa.containsKey(node)) return 0;
		List<int[]> list = pa.get(node);
		
		int a, b, w;
		a = b = 0;
		for (int i = 0; i < list.size(); i++) {
			int[] nums = list.get(i);
			w = dfs(nums[0]) + nums[1];
			if (a < w) {
				b = a;
				a = w;
			} else if (b < w) {
				b = w;
			}
		}
		if (max < a+b) {
			max = a+b;
		}
		
		return a;
	}
}