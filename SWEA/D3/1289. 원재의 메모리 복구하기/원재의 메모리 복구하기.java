
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
			String nums = sc.next();
            int ans = 0;
            boolean find = false;
            for (int i = 0; i < nums.length(); i++) {
                if (!find && nums.charAt(i) == '1') {
                    ans++;
                    find = true;
                }
                else if (find && nums.charAt(i) == '0') {
                    ans++;
                    find = false;
                }
            }
            System.out.println("#"+test_case+" "+ans);
		}
	}
}