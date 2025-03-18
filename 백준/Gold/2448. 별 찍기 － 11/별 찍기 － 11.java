import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static char[][] star;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		star = new char[N][N*2-1];
		for(int i = 0; i < N; i++) 
			Arrays.fill(star[i], ' ');
		makeAStar(3);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N*2-1; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	public static void makeAStar(int num) {
		if (num == 3) {
			star[0][N-1] = '*';
			star[1][N-2] = '*';
			star[1][N-1] = ' ';
			star[1][N] = '*';
			for (int i = 0; i < 5; i++) {
				star[2][N-3+i] = '*';
			}
		} else {
			for (int i = num/2; i < num; i++) {
				for (int j = 0; j <= i-num/2; j++) {
					star[i][N-1-num/2+j] = star[i-num/2][N-1+j];
					star[i][N-1-num/2-j] = star[i-num/2][N-1-j];
					star[i][N-1+num/2+j] = star[i-num/2][N-1+j];
					star[i][N-1+num/2-j] = star[i-num/2][N-1-j];
				}
			}
		}
		if (num == N) {
			return;
		}
		makeAStar(num*2);
	}
}