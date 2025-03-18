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
			String[] num = sc.next().split("");
            int person = 0;
            int sum = 0;
            for (int i =0; i < num.length; i++) {
                 sum += Integer.parseInt(num[i]);
                 if (sum +person > i) continue;
            	 else {
                     person++;
                 }
             }
            System.out.println("#"+test_case+" "+person);
		}
	}
}