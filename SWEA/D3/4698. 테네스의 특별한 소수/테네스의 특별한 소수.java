import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        boolean[] nums = new boolean[1000001];
        nums[0] = true;
        nums[1] = true;
    	for (int i = 2; i <= 1000 ; i++) {
            if (nums[i]) continue;
            for (int j = 2; j <= 1000000/i; j++) {
            nums[i*j] = true;
            }
        }
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int D = sc.nextInt();
            int A = sc.nextInt();
            int B = sc.nextInt();
            int sum = 0;
            for (int i = A; i <= B; i++) {
            	int j = i%10;
                int num = i/10;
                if (j == D) {
                	if (!(nums[i])) {
                        sum++;
                        continue;
                    }
                }
                while (num != 0) {
                    j = num % 10;
                    if (j == D) {
                		if (!(nums[i])) {
                        	sum++;
                        	break;
                    	}
                	}
                   num /= 10; 
                }
            }
            System.out.println("#"+test_case+" "+sum);
		}
    }
}