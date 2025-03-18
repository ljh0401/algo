import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;

class Solution
{
    static int[] rD = {1, 0, -1, 0};
    static int[] cD = {0, -1, 0, 1};
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int[][] snail = new int [N][N];
            int num = 1;
            int idx = 0;
            int c = 0;
            int r = 0;
            snail[c][r] = num;
			while(true) {
                if (0 > c+cD[idx%4] || c+cD[idx%4] > N-1 || 0 > r+rD[idx%4] || r+rD[idx%4] > N-1) idx++;
                else if (snail[c+cD[idx%4]][r+rD[idx%4]] == 0) {
                	snail[c+cD[idx%4]][r+rD[idx%4]] = ++num;
                    c += cD[idx%4];
                    r += rD[idx%4];
                }
                else idx++;
				if (num == N*N) {break;}
            }
            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
            	System.out.print(snail[i][j]+" ");
                }
                System.out.print("\n");
            }
		}
	}
}