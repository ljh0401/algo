import java.util.Scanner;

public class Solution {
	static int N;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++ ) {
			N = sc.nextInt();
			answer = 0;
			boolean[][] map = new boolean[N][N];
			find(map, 0);
			System.out.println("#"+test+" "+ answer);
		}
	}
	public static void find(boolean[][] map, int count) {
		if (count == N) {
			answer += 1;
			return;
		}
		A:
		for (int i = 0; i < N; i++) {
			if(!map[count][i]) {
				for (int j = 0; j < count; j++) {
					if (map[j][i]) continue A;
				}
				for (int s = count-1, t = i-1; s >= 0 && t >=0; s--, t--) {
					if (map[s][t]) continue A;
				}
				for (int s = count-1, t = i+1; s >= 0 && t < N; s--, t++) {
					if (map[s][t]) continue A;
				}
				map[count][i] = true;
				find(map, count+1);
				map[count][i] = false;
			}
		}
	}
}