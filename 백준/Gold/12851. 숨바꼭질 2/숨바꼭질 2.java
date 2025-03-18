import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int way = 0;
        if (K <= N) {
        	min = N-K;
        	way = 1;
        } else {
        	int[] nums = new int[K+2];
        	Arrays.fill(nums, 100000);
        	int[] save = new int[K+2];
        	Queue<int[]> que = new LinkedList<>();
        	que.add(new int[] {N, 0});
        	while (!que.isEmpty()) {
        		int[] tmp = que.poll();
        		int n = tmp[0];
        		int c = tmp[1];
        		if (c > min) continue;
        		if (nums[n] < c) {
        			continue;
        		} else if (nums[n] == c) {
        			save[n] += 1;
        		} else {
        			nums[n] = c;
        			save[n] = 1;
        		}
        		if (n == K) {
        			min = Math.min(min, c);
        			continue;
        		}
        		if (n+1 <= K+1)
        			que.add(new int[] {n+1, c+1});
        		if (0 < n-1)
        			que.add(new int[] {n-1, c+1});
        		if (2*n <= K+1)
        			que.add(new int[] {2*n, c+1});
        	}
        	way = save[K];
        }
        System.out.print(min+"\n"+way);
    }
    
}