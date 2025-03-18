import java.io.*;
import java.util.*;

public class Main {
    static int h, w;
    static char[][] map;
    static int[] cx = {1, -1, 0, 0};
    static int[] cy = {0, 0, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h][w];
            int[][] prisoners = new int[2][];
            boolean firstFound = false;
            List<int[]> borderList = new ArrayList<>();
            
            for (int i = 0; i < h; i++) {
                String line = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '$') {
                        if (!firstFound) {
                            prisoners[0] = new int[] {i, j};
                            firstFound = true;
                        } else {
                            prisoners[1] = new int[] {i, j};
                        }
                    }
                    if (map[i][j] != '*' && (i == 0 || i == h - 1 || j == 0 || j == w - 1)) {
                        borderList.add(new int[] {i, j, map[i][j] == '#' ? 1 : 0});
                    }
                }
            }
            
            int[][] distOutside = makeMap(borderList);
            int[][] distP0 = makeMap(prisoners[0][0], prisoners[0][1]);
            int[][] distP1 = makeMap(prisoners[1][0], prisoners[1][1]);
            
            int answer = bfs(prisoners[0][0], prisoners[0][1]) + bfs(prisoners[1][0], prisoners[1][1]);
            for (int i = 0; i < h; i++){
                for (int j = 0; j < w; j++){
                	int sum = Integer.MAX_VALUE;
                    if (distOutside[i][j] == Integer.MAX_VALUE)
                        continue;
                    else if (distP0[i][j] == Integer.MAX_VALUE && distP1[i][j] == Integer.MAX_VALUE) {
                    	continue;
                    } else if (distP0[i][j] == Integer.MAX_VALUE) {
                    	sum = distOutside[i][j] + distP1[i][j];
                    	if (map[i][j] == '#') sum -= 1;
                    } else if (distP1[i][j] == Integer.MAX_VALUE) {
                    	sum = distOutside[i][j] + distP0[i][j];
                    	if (map[i][j] == '#') sum -= 1;
                    } else {
                    	sum = distOutside[i][j] + distP0[i][j] + distP1[i][j];
                    	if (map[i][j] == '#') sum -= 2;
                    }
                    
                    answer = Math.min(answer, sum);
                }
            }
            
            System.out.println(answer);
        }
    }
    
    public static int bfs(int c, int r) {
    	PriorityQueue<int[]>que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
 	   que.add(new int[] {c, r, 0});
 	   boolean[][] vis = new boolean[h][w];
 	   while(!que.isEmpty()) {
 		   int[] tmp = que.poll();
 		   if ((tmp[0] == 0 || tmp[0] == h-1 || tmp[1] == 0 || tmp[1] == w-1) && (map[tmp[0]][tmp[1]] == '#' || map[tmp[0]][tmp[1]] == '.' || map[tmp[0]][tmp[1]] == '$')) {
 			   return tmp[2];
 		   }
 		   for(int i = 0; i < 4; i++) {
 			   int x = tmp[0] + cx[i];
 			   int y = tmp[1] + cy[i];
 			   
 			   if (x >= 0 && x < h && y >= 0 && y < w && !vis[x][y]) {
 				   vis[x][y] = true;
 				   if (map[x][y] == '*') {
 					   continue;
 				   } else if (map[x][y] == '.' || map[x][y] == '$') {
 					   if (x == 0 || x == h-1 || y == 0 || y == w-1) {
 						   return tmp[2];
 					   }
 					   que.add(new int[] {x, y, tmp[2]});
 				   } else {
 					   que.add(new int[] {x, y, tmp[2]+1});
 				   }
 			   }
 		   }
 	   } 
 	   return -1;
    }
    
    public static int[][] makeMap(int startRow, int startCol) {
        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[] {startRow, startCol});
        dist[startRow][startCol] = 0;
        
        while (!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int row = cur[0], col = cur[1];
            for (int d = 0; d < 4; d++){
                int nrow = row + cy[d];
                int ncol = col + cx[d];
                if (nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) continue;
                if (map[nrow][ncol] == '*') continue;
                int cost = dist[row][col] + (map[nrow][ncol] == '#' ? 1 : 0);
                if (cost < dist[nrow][ncol]){
                    dist[nrow][ncol] = cost;
                    if (map[nrow][ncol] == '#')
                        dq.addLast(new int[] {nrow, ncol});
                    else
                        dq.addFirst(new int[] {nrow, ncol});
                }
            }
        }
        return dist;
    }
    
    public static int[][] makeMap(List<int[]> starts) {
        int[][] dist = new int[h][w];
        for (int i = 0; i < h; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        for (int[] s : starts) {
            int r = s[0], c = s[1], cost = s[2];
            if(cost < dist[r][c]) {
                dist[r][c] = cost;
                if(map[r][c] == '#')
                    dq.addLast(new int[] {r, c});
                else
                    dq.addFirst(new int[] {r, c});
            }
        }
        while(!dq.isEmpty()){
            int[] cur = dq.pollFirst();
            int row = cur[0], col = cur[1];
            for (int d = 0; d < 4; d++){
                int nrow = row + cy[d];
                int ncol = col + cx[d];
                if(nrow < 0 || nrow >= h || ncol < 0 || ncol >= w) continue;
                if(map[nrow][ncol]=='*') continue;
                int cost = dist[row][col] + (map[nrow][ncol]=='#' ? 1 : 0);
                if(cost < dist[nrow][ncol]){
                    dist[nrow][ncol] = cost;
                    if(map[nrow][ncol]=='#')
                        dq.addLast(new int[] {nrow, ncol});
                    else
                        dq.addFirst(new int[] {nrow, ncol});
                }
            }
        }
        return dist;
    }
}
