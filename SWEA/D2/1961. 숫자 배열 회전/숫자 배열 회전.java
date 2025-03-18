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
            sc.nextLine();
            String[][] nMap = new String[N][N];
            String[][] nMap9 = new String[N][N];
            String[][] nMap18 = new String[N][N];
            String[][] nMap27 = new String[N][N];
            for (int i =0 ; i < N ; i++) {
            	nMap[i] = sc.nextLine().split(" ");
            }
            for (int i =0 ; i < N ; i++) {
            	for (int j = 0; j< N ; j++) {
                	nMap9[j][N-1-i] = nMap[i][j];
                    nMap18[N-1-i][N-1-j] = nMap[i][j];
                    nMap27[N-1-j][i] = nMap[i][j];
                }
            }
        System.out.println("#"+test_case);
            for (int i =0 ; i < N ; i++) {
            	for (String s : nMap9[i]) System.out.print(s);
                System.out.print(" ");
                for (String s : nMap18[i]) System.out.print(s);
                System.out.print(" ");
                for (String s : nMap27[i]) System.out.print(s);
                System.out.print("\n");
            }
        }
	}
}