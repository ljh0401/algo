import java.util.*;
import java.io.*;

public class Main {
	static int max = Integer.MAX_VALUE;
	static int[] dx = new int[] {-1, 0, 1, 0 }, dy = new int[] {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char[][] house = new char[N][N];
        int[] door = new int[2];
        for (int i = 0; i < N; i++) {
        	String word = br.readLine();
        	for (int j = 0; j < N; j++) {
        		house[i][j] = word.charAt(j);
        		if (house[i][j] == '#') {
        			door[0] = i;
        			door[1] = j;
        		}
        	}
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        for (int i = 0; i < 4; i++) pq.add(new int[] {door[0], door[1], i, 0});
        boolean[][] visMap = new boolean[N][N];
        while(!pq.isEmpty()) {
        	int[] loc = pq.poll();
        	int idx = loc[2];
        	int x = loc[0] + dx[idx];
        	int y = loc[1] + dy[idx];
        	int oD = loc[3];
        	if (x < 0 || y < 0 || x > N-1 || y > N-1 || house[x][y] == '*') {
        		continue;
        	}
        	else if (house[x][y] == '.') {
        		pq.add(new int[] {x, y, idx, oD});
        	} 
        	else if (house[x][y] == '!') {
        		if (visMap[x][y]) continue;
        		visMap[x][y] = true;
        		int m1 = idx+1;
        		int m2 = idx-1;
        		if (m1 > 3) m1 = 0;
        		if (m2 < 0) m2 = 3;
        		pq.add(new int[] {x, y, idx, oD});
        		pq.add(new int[] {x, y, m1, oD+1});
        		pq.add(new int[] {x, y, m2, oD+1});
        	}
        	else if (house[x][y] == '#') {
        		System.out.println(oD);
        		break;
        	}
        }
    }
}
