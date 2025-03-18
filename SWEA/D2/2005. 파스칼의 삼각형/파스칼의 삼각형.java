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
            int h = 1;
            int[] nums = new int[N];
            nums[0] = 1;
            System.out.println("#"+test_case);
            for (int i = 0; i < N; i++) {
                int[] tmp = new int[h];
            	for (int j = 0; j < h; j++) {
                    if (j-1 >= 0 ) tmp[j] = nums[j-1] + nums[j];
                    else tmp[j] = 1;
                    System.out.print(tmp[j]+" ");
                }
                System.out.println();
                for (int j = 0; j < h; j++) {
                    nums[j] = tmp[j];
                }
                h++;
            } 
            
		}
	}
}