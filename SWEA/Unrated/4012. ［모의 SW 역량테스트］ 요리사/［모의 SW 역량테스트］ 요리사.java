import java.util.Scanner;

class Solution
{
	static Scanner sc = new Scanner(System.in);
	static int N, size, min;
	static int[][] score;
	public static void main(String args[]) throws Exception
	{
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N= sc.nextInt();
			size = N/2;
			min = Integer.MAX_VALUE;
			score = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					score[i][j] = sc.nextInt();
				}
			}
			boolean[] yam = new boolean[N];
			yam[0] = true;
			yamyam(1, 1, yam);
			System.out.println("#"+test_case+" "+min);
		}
	}
	
	public static void yamyam(int idx , int sidx, boolean[] yam) {
		if (min == 0) return;
		if (idx >= N && sidx != size) return;
		if (sidx == size) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if (yam[i]) {
						if (yam[j]) {
							sum1 += (score[i][j] + score[j][i]);
						}
					}
					else {
						if (!yam[j]) {
							sum2 += (score[i][j] + score[j][i]);
						}						
					}
				}
			}
			min = Math.min(min, Math.abs(sum1-sum2));
			return;
		}
		for (int i = idx; i <= N - size + sidx; i++) {
			yam[i] = true;
			yamyam(i+1, sidx+1, yam);
			yam[i] = false;
		}
	}
}

