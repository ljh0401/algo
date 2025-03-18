import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
    static int N, M;
    static int[][] mR;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
            M = sc.nextInt();
            String line;
            mR = new int[N][3];
            for (int i = 0; i < N; i++) {
                line = sc.next();
                for (int j = 0; j < M; j++) {
                	switch (line.charAt(j)) {
                        case 'W' :
                        	mR[i][0] += 1;
                            break;
                        case 'B' : 
                        	mR[i][1] += 1;
                            break;
                        case 'R' : 
                        	mR[i][2] += 1;
                            break;
                    }
                }
            }
            int min = 100000;
            int s = 1;
            int ans;
           while (s < N-1) {
            	int t = s+1;
                while (t < N) {
                    ans = find(s, t);
                    if ( ans < min) min = ans;
                	t++;
                }
               s++;
            }
            System.out.println("#"+test_case+" "+min);
		}
	}
    public static int find (int s, int t)
        {
            int cor = 0;
            for (int i = 0;i < s; i++){
            	cor += (mR[i][1] + mR[i][2]);
            }
            for (int i = s;i < t; i++){
                cor += (mR[i][0] + mR[i][2]);
            }
            for (int i = t;i < N; i++){
               	cor += (mR[i][0] + mR[i][1]);
            }
            return cor;
        }
}