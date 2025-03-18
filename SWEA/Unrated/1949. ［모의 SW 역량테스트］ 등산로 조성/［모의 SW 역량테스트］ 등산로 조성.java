
import java.util.Scanner;

class Solution
{
    static int N, K;
    static int[][] map;
    static boolean[][] vi;
    static int[] dC = {0, 0, 1, -1};
    static int[] dR = {1, -1, 0, 0};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            K = sc.nextInt();
            map = new int[N][N];
            vi = new boolean[N][N];
            int max = 0;
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                    int num = sc.nextInt();
                    map[i][j] = num;
                    max = Math.max(num, max);
                }
            }
            int ans = 0;
            for (int i = 0; i < N; i++) {
            	for (int j = 0; j < N; j++) {
                    if (map[i][j] == max) {
                    	ans = Math.max(find(i, j , 1, 0), ans);
                    }
                }
            }
            System.out.println("#"+test_case+" "+ ans);
		}
	}
    public static int find (int c, int r, int count, int work) {
    	int max = count;
       	vi[c][r] = true;
        for (int i = 0; i < 4; i++) {
        	int CC = c + dC[i];
            int RR = r + dR[i];
            if (0<= CC && CC < N && 0 <= RR && RR < N) {
            	if (vi[CC][RR]) continue;
                if (map[CC][RR] < map[c][r]) {
                    max = Math.max(find(CC, RR, count + 1, work), max);
                }
                else {
                    if (work == 0) {
                    	if ((map[CC][RR] - K )< map[c][r]) {
                            int tmp = map[CC][RR];
                			map[CC][RR] = map[c][r] - 1;
                            max = Math.max(find(CC, RR, count + 1, 1), max);
                            map[CC][RR] = tmp;
                    	}
                    }
                }
            }
        }
        vi[c][r] = false;
        return max;
    }
}