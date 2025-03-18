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
            String[] cards = new String[N];
            for (int i = 0; i < N; i++) {
            	if (i <= (N+1)/2-1) {
                	cards[2*i] = sc.next();
                }
                else {
                	cards[(i - (N+1)/2)*2+1] = sc.next();
                }
            }
            System.out.print("#"+test_case);
            for  (int i = 0; i < N; i++) {
                System.out.print(" "+cards[i]);
            }
            System.out.println();
		}
	}
}