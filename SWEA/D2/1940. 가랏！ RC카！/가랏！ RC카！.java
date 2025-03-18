
import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
            int V = 0;
            int L = 0;
            for (int n = 0; n < N; n++) {
            	int A = sc.nextInt();
                if (A == 2) {
                    int a = sc.nextInt();
                    V -= a;
                    if (V < 0) V = 0;
                }
                else if (A == 1) {
                    int a = sc.nextInt();
                    V += a;
                }
                L += V;
            }
            System.out.println("#"+test_case+" "+L);
		}
	}
}