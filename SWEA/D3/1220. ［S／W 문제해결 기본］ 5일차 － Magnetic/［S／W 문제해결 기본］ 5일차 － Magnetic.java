import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int B = sc.nextInt();
            sc.nextLine();
            String[][] B_T = new String[B][B];
            int ans = 0;
            for (int i = 0; i < B; i++) {
                B_T[i] = sc.nextLine().split(" ");
            }
            for (int k = 0; k < B; k++) {
                int tmp = 0;
                for (int j =0; j <B; j++) {
                	if (tmp == 0 && B_T[j][k].equals("1")) {
                    	tmp = 1;
                    }
                    else if (tmp == 1 && B_T[j][k].equals("2")) {
                    	tmp = 0;
                        ans += 1;
                    }
                }
            }
           	System.out.println("#"+test_case+" "+ans);
		}
	}
}