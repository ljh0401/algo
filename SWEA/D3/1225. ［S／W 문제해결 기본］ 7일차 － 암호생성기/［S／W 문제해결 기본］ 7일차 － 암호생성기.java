
import java.util.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
        
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int test = sc.nextInt();
            List<Integer> queue = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                queue.add(sc.nextInt());
            }
            int n = 1;
            while (true) {
            	if (queue.get(0) - n > 0) {
                	int tmp = queue.get(0)-n;
                    queue.remove(0);
                    queue.add(tmp);
                    n++;
                }
                else {
                	int tmp = 0;
                    queue.remove(0);
                    queue.add(tmp);
                    break;
                }
                if (n == 6) {
                	n = 1;
                }
            }
            System.out.print("#"+test);
            for (int i = 0; i < 8; i++) {
                System.out.print(" "+queue.get(i));
            }
            System.out.println();
		}
	}
}