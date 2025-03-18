import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long[] seg, nums;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		seg = new long[4*N];
		nums = new long[N+1];
		for (int i = 1; i < N+1; i++) {
			nums[i] = Long.parseLong(br.readLine());
		}
		init(1, 1, N);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			if (f == 1) {
				long e = Long.parseLong(st.nextToken());
				long diff = e - nums[s];
				nums[s] = e;
				update(1, 1, N, s, diff);
			} else {
				int e = Integer.parseInt(st.nextToken());
				sb.append(sum(1, 1, N, s, e)+"\n");
			}
		}
		System.out.println(sb);
	}
	
	public static void init(int node, int start, int end) {
		if (start == end) {
			seg[node] = nums[start];
			return;
		}
		int mid = (start+end) /2;
		init(2*node, start, mid);
		init(2*node+1, mid+1, end);
		seg[node] = seg[2*node] + seg[2*node+1];
	}
	
	public static long sum(int node, int start, int end, int left, int right) {
		if (right < start | end < left) {
			return 0;
		}
		if (left <= start && end <= right) {
			return seg[node];
		}
		
		int mid = (start+end)/2;
		long s1  = sum(2*node, start, mid, left, right);
		long s2 = sum(2*node+1, mid+1, end, left, right);
		return s1+s2;
	}
	
	public static void update(int node, int start, int end, int idx, long diff) {
		if (idx < start | end < idx) {
			return;
		}
		
		seg[node] += diff;
		
		if (start != end) {
			int mid = (start+end)/2;
			update(2*node, start, mid, idx, diff);
			update(2*node+1, mid+1, end, idx, diff);
		}	
	} 
}