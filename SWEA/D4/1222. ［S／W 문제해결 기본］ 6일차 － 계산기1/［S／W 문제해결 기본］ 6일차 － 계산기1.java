import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int  N = sc.nextInt();
            String[] words = sc.next().split("");
            List<String> cal = new ArrayList<>();
            List<String> idx = new ArrayList<>();
            for (int i = 0; i < N; i++) {
            	if (words[i].equals("+")) {
                	idx.add("+");
                    continue;
                }
				cal.add(words[i]);
                if (idx.size() != 0) {
                	cal.add(idx.get(0));
                    idx.remove(0);
                }
            }
            while(cal.size() != 1) {
            	int num1 = Integer.parseInt(cal.get(0));
                int num2 = Integer.parseInt(cal.get(1));
   				if (cal.get(2).equals("+")) {
                    cal.remove(0);
                    cal.remove(1);
                    cal.set(0, Integer.toString(num1+num2));
                }
            }
            int ans =  Integer.parseInt(cal.get(0)); 
			System.out.println("#"+test_case+" "+ans);
		}
	}
}