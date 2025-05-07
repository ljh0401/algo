import java.util.*;
import java.io.*;

public class Main {
	static int[][] dis = new int[][] {{0, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}, {-1, -1}, {-1, 0}, {-1, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] map = new char[8][8];
        int wall = 7;
        for (int i = 0; i < 8; i++) {
        	boolean last = false;
        	String word = br.readLine();
        	for (int j = 0; j < 8; j++) {
        		map[i][j] = word.charAt(j);
        		if (map[i][j] == '#') last = true;
        	}
        	if (last && i < wall) wall = i; 
        }
        wall = 7 - wall;
        Queue<int[]> q = new ArrayDeque<>();
        int answer = 0;
        q.add(new int[] {7, 0, 0});
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (cur[2] >= wall) {
        		answer = 1;
        		break;
        		}
        	for(int[] tmp : dis) {
        		int x = cur[0] + tmp[0];
        		int y = cur[1] + tmp[1];
        		int t = cur[2] + 1;
        		if (x < 0 || y < 0 || x > 7 || y > 7) continue;
        		if (x - t + 1 >= 0) {
        			if (map[x-t+1][y] == '#') continue;
        		}
        		if (x - t >= 0) {
        			if (map[x-t][y] == '#') continue;
        		}
        		q.add(new int[] {x, y, t});
        	}
        }
        System.out.print(answer);
    }
}
