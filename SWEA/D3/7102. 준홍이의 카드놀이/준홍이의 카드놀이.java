
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
			int N = sc.nextInt();
            int M = sc.nextInt();
            int num;
            int sub;
            if (N > M) {
                num = M;
                sub = N - M;
            }
            else {
            	num = N;
                sub = M - N;
            }
            System.out.print("#"+test_case);
            for (int i = 0; i <= sub; i++) {
            	++num;
                System.out.print(" "+num);
            }
            System.out.println();
		}
	}
}