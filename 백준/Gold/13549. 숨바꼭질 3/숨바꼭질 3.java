import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int[] time = new int[100101];
	public static void main(String[] args) throws IOException{
		Arrays.fill(time, 100000);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int answer = 0;
		if (N >= K) {
			answer = N-K;
		}
		else {
			pq.add(new int[] {N, 0});
			while(!pq.isEmpty()) {
				int[] tmp = pq.poll();
				int k = tmp[0];
				int t = tmp[1];
				if (k == K) {
					answer = t;
					break;
				}
				if (time[k] <= t) continue;
				time[k] = t;
				int v1 = k*2;
				int v2 = k+1;
				int v3 = k-1;
				if(v1 == K ) {
					answer = t;
					break;
				}
				if (v1 <= 100100) {
					pq.add(new int[] {v1, t});
				}
				if (v2 <= 100100) {
					pq.add(new int[] {v2, t+1});
				}
				if (v3 < 0) continue;
				pq.add(new int[] {v3, t+1});
			}
		}
		System.out.print(answer);
	}
}