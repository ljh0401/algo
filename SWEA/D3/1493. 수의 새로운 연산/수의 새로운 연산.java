import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int p = sc.nextInt();
            int q = sc.nextInt();
            int p_i = 0;
            int p_p = 1;
            int q_i = 0;
            int q_q = 1;
            for (int i =1; i<150; i++) {
                p -= i;
                if (p > 0) {
                    p_i = i;
                    p_p = p; 
                }
                q -= i;
                if (q > 0) {
                    q_i = i;
                    q_q = q;
                }
                if (q < 0 && p < 0) break;
            }
            int x = p_p + q_q;
            int y = p_i + q_i -p_p -q_q + 4;
            int k = x+y-1;
            int k_n = 0;
            for (int i =1; i< k; i++){
                k_n += i;
            }
            int ans = k_n + x;
            System.out.println("#"+test_case+" "+ans);
		}
	}
}