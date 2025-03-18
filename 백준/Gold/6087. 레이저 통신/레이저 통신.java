import java.io.*;
import java.util.*;

public class Main {
	static List<int[]> list;
	static int[][] map;
	static int W, H;
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    W = Integer.parseInt(st.nextToken());
	    H = Integer.parseInt(st.nextToken());
	    map = new int[H][W];
	    list = new ArrayList<>();
	    for (int i = 0; i < H; i++) {
	    	String word = br.readLine();
	    	for (int j = 0; j < W; j++) {
	    		char m = word.charAt(j);
	    		if (m == '.') {
	    			continue;
	    		} else if (m == '*') {
	    			map[i][j] = -1;
	    		} else if (m == 'C') {
	    			list.add(new int[] {i, j});
	    		}
	    	}
	    }
	    bfs();
	    int[] last = list.get(1);
	    System.out.print((map[last[0]][last[1]] - 1));
	}
    
    public static void bfs(){
    	Queue<int[]> queue = new ArrayDeque<>();
    	int[] first = list.get(0);
    	int[] last = list.get(1);
    	queue.add(new int[] {first[0], first[1], 1});
    	while(!queue.isEmpty()) {
    		int[] tmp = queue.poll();
    		int y = tmp[0];
    		int x = tmp[1];
    		boolean up = true;
    		boolean down = true;
    		boolean right = true;
    		boolean left = true;
    		for (int i = 1; up||down||right||left; i++) {
    			if (up) {
    				int u = y-i;
    				if (u >= 0 && u < H && map[u][x] != -1) {
    					if (map[u][x] > 0) {
    					} else {
    						map[u][x] = tmp[2];
        					queue.add(new int[] {u, x, tmp[2]+1});
    					}
    				}
    				else {
    					up = false;
    				}
    			}
    			if (down) {
    				int d = y+i;
    				if (d >= 0 && d < H && map[d][x] != -1) {
    					if (map[d][x] > 0) {
    					} else {
    						map[d][x] = tmp[2];
        					queue.add(new int[] {d, x, tmp[2]+1});
    					}
    				}
    				else {
    					down = false;
    				}
    			}
    			if (right) {
    				int r = x+i;
    				if (r >= 0 && r < W && map[y][r] != -1) {
    					if (map[y][r] > 0) {
    					} else {
    						map[y][r] = tmp[2];
        					queue.add(new int[] {y, r, tmp[2]+1});
    					}
    				}
    				else {
    					right = false;
    				}
    			}
    			if (left) {
    				int l = x-i;
    				if (l >= 0 && l < W && map[y][l] != -1) {
    					if (map[y][l] > 0) {
    					} else {
    						map[y][l] = tmp[2];
        					queue.add(new int[] {y, l, tmp[2]+1});
    					}
    				}
    				else {
    					left = false;
    				}
    			}
    		}
    		if(map[last[0]][last[1]] != 0) {
    			return;
    		}
    	}
    }
}
