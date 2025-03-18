import java.util.Scanner;
class Solution
{
    static int N;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = sc.nextInt();
            int ans = 0;
            N = sc.nextInt();
            int M = sc.nextInt();
            ans = mult (M, N);
            System.out.println("#"+test+" "+ans);
		}
	}
    public static int mult (int m, int cur) {
        if (m == 1) return cur;
        if (m%2 == 1) {
            int num = mult(m/2, cur);
        	return num*num*N;
        }
        else {
        	int num = mult(m/2, cur);
            return num*num;
        }
    }
}