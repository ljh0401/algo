import java.io.*;
import java.util.*;

public class Main {
	static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int s = Integer.parseInt(st.nextToken());
        	int e = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	list.add(new int[] {s, e, d});
        }
        long[] dis = new long[n+1];
        Arrays.fill(dis, max);
        dis[1] = 0;
        for (int i = 0; i < n; i++) {
        	for(int[] num : list) {
        		int start = num[0];
        		int end = num[1];
        		int distance = num[2];
        		if(dis[start] != max && dis[end] > dis[start]+distance) {        			
        			dis[end] = dis[start]+distance;
        			if (i == n-1) {
        				System.out.print(-1);
        				return;
        			}
        		}
        	}      
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= n; i++) {
        	if (dis[i] == max) {
        		sb.append(-1+"\n");
        	}
        	else {        		
        		sb.append(dis[i]+"\n");
        	}
        }
        System.out.print(sb);
    }
}
