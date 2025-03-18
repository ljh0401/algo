
import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] nums;
	static int N, M;
	static int[] tmp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];
		tmp = new int[M];
		for (int i = 1; i <= N; i++) {
			nums[i-1] = i;
		}
		find(0,0);
		System.out.print(sb);
	}
	
	static void find(int idx, int count) {
		if (count ==M) {
			for (int i = 0; i < M; i++) {
				sb.append(tmp[i]+" ");	
			}
			sb.append("\n");
			return;
		}
		if(idx >= N) {
			return;
		}
		tmp[count] = nums[idx];
		find(idx+1, count+1);
		find(idx+1, count);
	}
}