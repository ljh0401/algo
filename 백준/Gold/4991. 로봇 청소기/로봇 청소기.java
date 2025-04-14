import java.io.*;
import java.util.*;

public class Main {
	static int[][] dirt = new int[11][];
	static int[][] cul = new int[11][11], tmpMap, tmp;
	static int size, min = 1000000, n, m;
	static boolean[] vis;
	static boolean[][] visMap;
	static int[] dx = new int[] {0, 0, 1, -1}, dy = new int[] {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringBuilder sb = new StringBuilder();
	    while(true) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	n = Integer.parseInt(st.nextToken());
	    	m = Integer.parseInt(st.nextToken());
	    	if (n == 0) break;
	    	min = 1000000;
	    	size = 0;
	    	tmp = new int[m][n];
	    	for (int i = 0; i < m; i++) {
	    		String word = br.readLine();
	    		for (int j = 0; j < n; j++) {
	    			char ch = word.charAt(j);
	    			if (ch == '.') {
	    				tmp[i][j] = 0;
	    			} else if (ch == 'x') {
	    				tmp[i][j] = -1;
	    			} else if (ch == '*') {
	    				tmp[i][j] = 1;
	    				size++;
	    				dirt[size] = new int[] {i, j}; 
	    			} else if (ch == 'o'){
	    				tmp[i][j] = 0;
	    				dirt[0] = new int[] {i, j};
	    			}
	    		}
	    	}
	    	length();
	    	vis = new boolean[size+1];
	    	vis[0] = true;
	    	sb.append(find(0, 0)+"\n");
	    }
	    System.out.print(sb);
    }
    
    public static void length() {
    	for (int i = 0; i <= size; i++) {
    		tmpMap = new int[m][n];
	    	visMap = new boolean[m][n];
    		int[] num2 = dirt[i];
    		Queue<int[]> que = new ArrayDeque<>();
    		que.add(new int[] {num2[0], num2[1], 0});
    		visMap[num2[0]][num2[1]] = true;
    		while(!que.isEmpty()) {
    			int[] tmpA = que.poll();
    			for (int t = 0 ; t <4; t++ ) {
    				int x = tmpA[0] + dx[t];
    				int y = tmpA[1] + dy[t];
    				if (x < 0 || y < 0 || x >= m || y >= n ) {
    					continue;
    				}
    				if (visMap[x][y]) continue;
    				if (tmp[x][y] == -1) continue;
    				visMap[x][y] = true;
    				que.add(new int[] {x, y, tmpA[2]+1});
    				tmpMap[x][y] = tmpA[2]+1;
    			}
    		}
    		for (int j = i+1; j <= size; j++) {
    			int[] num1 = dirt[j];
    			cul[i][j] = tmpMap[num1[0]][num1[1]];
    			cul[j][i] = cul[i][j];
    		}
    	}
    }
    
    public static int find(int start, int ans) {
    	if (ans > min) return min;
    	boolean all = true;
    	for (int i = 0; i <= size; i++) {
    		if (vis[i]) continue;
    		if (start == i) continue; 
    		if (cul[start][i] == 0) return -1;
    		all = false;
    		vis[i] = true;
    		min = Math.min(find(i, ans+cul[start][i]), min);
    		vis[i] = false;
    	}
    	if (all) return ans;
    	return min;
    }
}