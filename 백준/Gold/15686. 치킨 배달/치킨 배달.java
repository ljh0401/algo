import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int chiLen, M, homeLen;
	static Map<Integer, int[]> map;
	static boolean[] sel;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		List<int[]> home = new LinkedList<>();
		List<int[]> chi = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp == 1) home.add(new int[] {i, j});
				else if (tmp == 2) chi.add(new int[] {i, j});
			}
		}
		
		map = new HashMap<>();
		homeLen = home.size();
		chiLen = chi.size();
		
		for (int i = 0; i < homeLen; i++) {
			int[] hTmp = home.get(i);
			if (!map.containsKey(i)) {
				map.put(i, new int[chiLen]);
			}
			for (int j = 0; j < chiLen; j++) {
				int[] cTmp = chi.get(j);
				map.get(i)[j] = Math.abs(hTmp[0]-cTmp[0]) + Math.abs(hTmp[1]-cTmp[1]);
			}
		}
		
		sel = new boolean[chiLen];
		int answer = find(0, 0);

		System.out.print(answer);
	}
	
	public static int find(int num, int full) {
		if (full == M ) {
			return cal();
		}
		if (num >= chiLen ) {
			return Integer.MAX_VALUE;
		}
		sel[num] = true;
		int find1 = find(num+1, full+1);
		sel[num] = false;
		int find2 = find(num+1, full);
		return Math.min(find1, find2);
	}
	
	public static int cal() {
		int[] chichi = new int[homeLen];
		Arrays.fill(chichi, Integer.MAX_VALUE);
		for (int i = 0; i < chiLen; i++) {
			if (sel[i]) {
				for (int j = 0; j < homeLen; j++) {
					chichi[j] = Math.min(chichi[j], map.get(j)[i]);
				}
			}
		}
		int min = 0;
		for (int i = 0; i < homeLen; i++) {
			min += chichi[i];
		}
		return min;
	}
}