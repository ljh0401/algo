import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int chance = sc.nextInt();
            int[] boxes = new int[101];
            int find = 0;
            int ans = 0;
            for (int i = 0; i < 100 ;i++) {
                int tmp = sc.nextInt();
                find += tmp%2;
            	boxes[tmp] += 1;
            }
            for (int i = 99; i > 0 ;i--) {
                boxes[i] += boxes[i+1];
            }
            int usum = 0;
            int dsum = 0;
            int uIdx = 0;
            int dIdx = 0;
            for (int i = 1; i < 101; i++) {
                dsum += (100 - boxes[i]);
                if (dsum > chance) {
                    dIdx = i-1;
                    break;
                }
            }
            for (int i = 100; i > 0; i--) {
                usum += boxes[i];
                if (usum >= chance) {
                    uIdx = i;
                    break;
                }
            }
        	if (dIdx >= uIdx && find%2 == 0) {
        		ans = 0;
        	}
        	else if (dIdx >= uIdx) {
        		ans = 1;
        	}
        	else {
        		ans = uIdx-dIdx;
        	}
        	System.out.println("#"+test_case+" "+ans);
		}
	}
}