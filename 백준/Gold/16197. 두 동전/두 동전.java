
import java.io.*;
import java.util.*;

public class Main {
	static int[] Dc = {1, -1, 0, 0};
	static int[] Dr = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		Queue<int[][]> queue = new LinkedList<>();
		int[][] coin = new int[3][];
		int size = 0;
		for (int i = 0; i < N; i++) {
			String[] word = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				String c = word[j];
				if (c.equals("."))
					map[i][j] = 0;
				else if (c.equals("#"))
					map[i][j] = 1;
				else {
					map[i][j] = 0;
					coin[size++] = new int[] {i, j};
				}
			}
		}
        coin[2] = new int[] {0};
		queue.add(coin);
		int answer = -1;
		A:
		while(!queue.isEmpty()) {
			int[][] C = queue.poll();
			int[] coin1 = C[0];
			int[] coin2 = C[1];
			int count = C[2][0];
			if (count+1 > 10) {
				answer = -1;
				break;
			}
			int don = 0;
			for (int i = 0; i< 4; i++) {
                int[][] save = new int[3][];
				int c1r = coin1[0]+Dr[i];
				int c1c = coin1[1]+Dc[i];
				int c2r = coin2[0]+Dr[i];
				int c2c = coin2[1]+Dc[i];
				int stop = 0;
				if (c1r >= 0 && c1r < N && c1c >= 0 && c1c < M) {
					if (map[c1r][c1c] != 1) {
						save[0] = new int[] {c1r, c1c};
					}
					else {
						save[0] = coin1;
						stop += 1;
					}
				}
				else {
					don+=1;
				}
				if (c2r >= 0 && c2r < N && c2c >= 0 && c2c < M) {
					if (map[c2r][c2c] != 1) {
						save[1] = new int[] {c2r, c2c};
					}
					else {
						save[1] = coin2;
						stop +=1;
					}
				}
				else {
					don+=1;
				}
				if (stop == 2) {
					continue;
				}
				if (don == 1) {
					answer = count+1;
					break A;
				}
				else if (don == 2) {
                    don = 0;
					continue;
				}
				save[2] = new int[] {count+1};
				queue.add(save);
            }						
		}
		System.out.println(answer);
	}
}