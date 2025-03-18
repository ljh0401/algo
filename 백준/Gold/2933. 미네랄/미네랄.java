import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] cave;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cave = new char[R][C];
        for (int i = 0; i < R; i++) {
        	String line = br.readLine();
        	for (int j = 0; j < C; j++) {
        		cave[i][j] = line.charAt(j);
        	}
        }
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        boolean lr = true;
        while(st.hasMoreTokens()) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if (lr) {
        		left(tmp);
        		lr = false;
        	} else {
        		right(tmp);
        		lr = true;
        	}
        	cluster();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
        	for (int j = 0; j < C; j++) {
        		sb.append(cave[i][j]);
        	}
        	sb.append("\n");
        }
        System.out.print(sb);
    }
    
    public static void left(int l) {
    	for (int i = 0; i < C; i++) {
    		if (cave[R-l][i] == 'x') {
    			cave[R-l][i] = '.';
    			return;
    		}
    	}
    }
    
    public static void right(int r) {
    	for (int i = C-1; i >= 0; i--) {
    		if (cave[R-r][i] == 'x') {
    			cave[R-r][i] = '.';
    			return;
    		}
    	}
    }
    
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    public static void cluster() {
    	Queue<int[]> que = new ArrayDeque<>();
    	boolean[][] vis = new boolean[R][C];
    	for(int i = 0; i < C; i++) {
    		if (cave[R-1][i] == 'x') {
    			que.add(new int[] {R-1, i});
    			vis[R-1][i] = true;
    		}
    	}
    	while(!que.isEmpty()) {
    		int[] tmp = que.poll();
    		for (int j = 0; j < 4; j++) {
    			int x = tmp[0] + dx[j];
    			int y = tmp[1] + dy[j];
    			if (x >= 0 && x < R && y >= 0 && y < C ) {
    				if (vis[x][y]) {
    					continue;
    				}
    				if (cave[x][y] == 'x') {    					
    					vis[x][y] = true;
    					que.add(new int[] {x, y});
    				}
    			}
    		}
    	}
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		int min = 101;
		for (int j = 0; j < C; j++) {
			int idx = -1;
			for(int i = 0; i < R; i++) {
				if (vis[i][j]) {
					if (idx > 0) {
						min = Math.min(idx, min);
					}
					continue;
				}
				if (cave[i][j] == 'x') {
					pq.add(new int[] {i, j});
					idx = 0;
				}
				else if (idx >= 0)  {
					idx += 1;
					if (i == R-1) {
						min = Math.min(idx, min);
					}
				}
			}
		}
		while(!pq.isEmpty()) {
			int[] down = pq.poll();
			cave[down[0]+min][down[1]] = cave[down[0]][down[1]];
			cave[down[0]][down[1]] = '.';
		}
    }
}
