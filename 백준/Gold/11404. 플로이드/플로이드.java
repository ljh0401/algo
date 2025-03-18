import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
        	Arrays.fill(nums[i], 100001);
        	nums[i][i] = 0;
        }        
        for (int i = 0; i < m; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int start = Integer.parseInt(st.nextToken());
        	int end = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	nums[start-1][end-1] = Math.min(nums[start-1][end-1], w);
        }
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++)
        	Arrays.fill(answer[i], Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
        	boolean[] vis = new boolean[n];
        	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
        	pq.add(new int[] {i, 0});
        	while(!pq.isEmpty()) {
        		int[] tmp = pq.poll();
        		if (vis[tmp[0]]) continue;
        		vis[tmp[0]] = true;
        		for (int j = 0; j < n; j++) {
        			if (nums[tmp[0]][j] == 100001) continue;
        			answer[i][j] = Math.min(answer[i][j], tmp[1] + nums[tmp[0]][j]);
        			pq.add(new int[] {j, answer[i][j]});
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++ ) {
        	for (int j = 0; j < n; j++) {
        		if (answer[i][j] == Integer.MAX_VALUE) {
        			sb.append(0+" ");
        		} else {        			
        			sb.append(answer[i][j]+" ");
        		}
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
    }
}