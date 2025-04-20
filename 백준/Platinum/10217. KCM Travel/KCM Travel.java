import java.util.*;
import java.io.*;

public class Main {
	static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int test = 0; test < T; test++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int M = Integer.parseInt(st.nextToken());
        	int K = Integer.parseInt(st.nextToken());
        	HashMap<Integer, List<int[]>> hash = new HashMap<>();
            for (int i = 0; i < K; i++) {
            	st = new StringTokenizer(br.readLine());
            	int s = Integer.parseInt(st.nextToken());
            	if(!hash.containsKey(s)) hash.put(s, new ArrayList<>());
            	hash.get(s).add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            int[][] dp = new int[M+1][N+1];
            for(int i = 0; i < M+1; i++) {
            	Arrays.fill(dp[i], max);
            }
            dp[0][1] = 0;
            
            for(int i = 0; i <= M; i++) {
            	for(int j = 0; j <= N; j++) {
            		if(dp[i][j] == max) continue;
            		if (!hash.containsKey(j)) continue;
            		for(int[] tmp : hash.get(j)) {
            			int v = tmp[0];
            			int c = tmp[1];
            			int d = tmp[2];
            			int distance = dp[i][j]+ d;
            			if (i+c <= M && (dp[i+c][v] == max || dp[i+c][v] > distance)) {
        					dp[i+c][v] = distance;
            			}
            		}
            	}
            }
            int answer = max;
            for(int i = 0; i <= M; i++) {
            	if (dp[i][N] < answer ) {
            		answer = dp[i][N];
            	}
            }
            if (answer == max) {
            	System.out.println("Poor KCM");
            } else {
            	System.out.print(answer);
            }
        }
    }
}
