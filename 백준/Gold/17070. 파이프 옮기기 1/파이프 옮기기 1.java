import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Queue<int[][]> pipeQ = new LinkedList<>();
		int[][] map = new int[N][N];
		int[][][] bfs = new int[N][N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 1; i < N; i++) {
			if (map[0][i] == 1) break;
			bfs[0][i][0] = 1;
		}
		for (int i = 1; i < N; i++) {
			for (int j = 1; j < N; j++) {
				if (map[i][j] == 1) continue;
				bfs[i][j][0] += bfs[i][j-1][0] + bfs[i][j-1][2];
				bfs[i][j][1] += bfs[i-1][j][1] + bfs[i-1][j][2];
				if (map[i-1][j] == 1 || map[i][j-1] == 1) continue;
				bfs[i][j][2] += bfs[i-1][j-1][0] + bfs[i-1][j-1][1] + bfs[i-1][j-1][2] ;
			}
		}
		int answer = bfs[N-1][N-1][0] + bfs[N-1][N-1][1]+ bfs[N-1][N-1][2];
		System.out.print(answer);
	}
}