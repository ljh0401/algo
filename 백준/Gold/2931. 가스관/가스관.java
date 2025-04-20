import java.io.*;
import java.util.*;

public class Main {
	static int max = Integer.MAX_VALUE;
	static Pipe pUD = new Pipe(true, true, false, false);
	static Pipe pRL = new Pipe(false, false, true, true);
	static Pipe pUDRL = new Pipe(true, true, true, true);
	static Pipe p1 = new Pipe(false, true, true, false);
	static Pipe p2 = new Pipe(true, false, true, false);
	static Pipe p3 = new Pipe(true, false, false, true);
	static Pipe p4 = new Pipe(false, true, false, true);
	static int[] M, Z, er, dx = new int[] {0, 0, 1, -1}, dy = new int[] {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Pipe[][] map = new Pipe[R][C];
        for(int i = 0; i < R; i++) {
        	String s = br.readLine();
        	for(int j = 0; j < C; j++) {
        		switch (s.charAt(j)) {
				case '.': {
					map[i][j] = new Pipe();
					break;
				}
				case 'M': {
					map[i][j] = new Pipe();
					M = new int[] {i, j};
					break;
				}
				case 'Z': {
					map[i][j] = new Pipe();
					Z = new int[] {i, j};
					break;
				}
				case '|': {
					map[i][j] = pUD;
					break;
				}
				case '-': {
					map[i][j] = pRL;
					break;
				}
				case '+': {
					map[i][j] = pUDRL;
					break;
				}
				case '1': {
					map[i][j] = p1;
					break;
				}
				case '2': {
					map[i][j] = p2;
					break;
				}
				case '3': {
					map[i][j] = p3;
					break;
				}
				case '4': {
					map[i][j] = p4;
					break;
				}
				}
        	}
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vMap = new boolean[R][C];
        vMap[M[0]][M[1]] = true;
        for(int i = 0; i < 4; i++) {
        	int x = M[0] + dx[i];
        	int y = M[1] + dy[i];
        	if (x >= 0 && x < R && y >= 0 && y < C) {
        		if(map[x][y].can()) {
        			q.add(new int[] {x, y});
        		}
        	}
        }
        while(!q.isEmpty()) {
        	int[] tmp = q.poll();
        	int x = tmp[0];
        	int y = tmp[1];
        	if (vMap[x][y]) continue;
        	vMap[x][y] = true;
        	Pipe P = map[x][y];
        	boolean rou = false;
        	if (P.u) {
        		q.add(new int[] {x-1, y});
        		rou = true;
        	}
        	if (P.d) {
        		q.add(new int[] {x+1, y});
        		rou = true;
        	}
        	if (P.l) {
        		q.add(new int[] {x, y-1});
        		rou = true;
        	}
        	if (P.r) {
        		q.add(new int[] {x, y+1});
        		rou = true;
        	}
        	if (!rou) {
        		if (x == Z[0] && y == Z[1]) {
        			continue;
        		}
        		er = new int[] {x, y};
        		break;
        	}
        }
        boolean up = false, down = false, left = false, right = false;
        for(int i = 0; i < 4; i++) {
        	int x = er[0] + dx[i];
        	int y = er[1] + dy[i];
        	if (x >= 0 && x < R && y >= 0 && y < C) {
        		Pipe np = map[x][y];
        		if (i == 0 && np.l) right = true;
        		else if (i == 1 && np.r) left = true;
                else if (i == 2 && np.u) down = true;
                else if (i == 3 && np.d) up = true; 
        	}
        }
        
        char ans;
        if (up && down && left && right) ans = '+';
        else if (up && down) ans = '|';
        else if (left && right) ans = '-';
        else if (down && right) ans = '1';
        else if (up && right) ans = '2';
        else if (up && left) ans = '3';
        else ans = '4';

        System.out.print((er[0] + 1) + " " + (er[1] + 1) + " " + ans);
    }
    
    public static class Pipe {
    	boolean u;
    	boolean d;
    	boolean r;
    	boolean l;
    	
    	Pipe() {
    		u = false;
    		d = false;
    		r = false;
    		l = false;
    	}
    	
    	Pipe(boolean u, boolean d, boolean r, boolean l) {
    		this.u = u;
    		this.d = d;
    		this.r = r;
    		this.l = l;
    	}
    	
    	public boolean can() {
    		return u || d || r || l;
    	} 
    }
}
