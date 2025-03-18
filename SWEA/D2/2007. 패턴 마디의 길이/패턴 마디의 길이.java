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
			String[] word = sc.next().split("");
            int M = 1; 
            int ans = 0;
            while(true) {
                String W = null;
                int r_t = 0;
            	for (int i = 0; i < 30/M; i++) {
                    String rWord = null;
            		for (int j = 0; j < M; j++) {
                        rWord += word[i*M+j];
                	}
                    if (W == null) W = rWord;
                    if (W.equals(rWord)) r_t++;
                    else break;
            	}
                if (r_t == 30/M) {
                    ans = M;
                    break;
                }
                M++;
                if (M > 10) break;
        	}
            System.out.println("#"+test_case+" "+ans);
		}
	}
}