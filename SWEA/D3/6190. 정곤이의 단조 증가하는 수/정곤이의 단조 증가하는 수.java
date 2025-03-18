
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
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
            	int num = sc.nextInt();
                if (i != 0) nums = sort(nums, num, i);
                else nums[i] = num;
            }
            int max = -1;
            A:
            for (int i = N-1; i >= 0; i--) {
            	for (int j = i-1; j >= 0; j--) {
                    int dan = nums[i] * nums[j];
                    if (dan <= max) {
                        if ( j == i-1 ) {
                        break A;
                        }
                        continue;
                    }
                    if (isDan(dan)) {
                        max = dan;
                    }
                }
            }
            System.out.println("#"+test_case+" "+max);
        }
	}
    public static int[] sort(int[] nums, int num, int i) {
    	int j;
        for (j = i-1; j >= 0  && num < nums[j] ; j--) {
        	nums[j+1] = nums[j];
        }
        nums[j+1] = num;
        return nums;
    }
    
    public static boolean isDan(int dan) {
        int a = dan%10;
        dan /= 10;
        while(dan != 0) {
        	int b = dan%10;
            dan /= 10;
            if (a >= b) {
            a = b;
            continue;
            }
            return false;
        }
        return true;
    }
}