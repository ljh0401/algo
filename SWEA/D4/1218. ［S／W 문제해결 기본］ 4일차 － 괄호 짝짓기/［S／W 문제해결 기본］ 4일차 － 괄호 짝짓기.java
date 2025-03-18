import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            String[] words = sc.next().split("");
            List<Integer> stack = new ArrayList<>();
            int idx = 0;
            int ans = 1;
            for (int i = 0; i < N; i++) {
                int num = 0;
            	if (words[i].equals("(")) {
                	num = 1;
                }
                else if (words[i].equals("[")) {
                	num = 2;
                }
                else if (words[i].equals("{")) {
                	num = 3;
                }
                else if (words[i].equals("<")) {
                	num = 4;
                }
                else if (words[i].equals(")")) {
                	num = -1;
                }
                else if (words[i].equals("]")) {
                	num = -2;
                }
                else if (words[i].equals("}")) {
                	num = -3;
                }
                else if (words[i].equals(">")){
                	num = -4;
                }
                if (num > 0) {
                	stack.add(num);
                    idx++;
                }
                else if (num < 0) {
                	if (idx-1 >= 0){
		            	if (stack.get(idx-1) == -num) {
                            
		                	stack.remove(idx-1);
		                    idx--;
		                }
                        else {
                			ans = 0;
                			break;
                		}
                	}
                	else {
                		ans = 0;
                		break;
                	}
                }
            }
           if (idx > 0) {
            	ans = 0;
            }
            System.out.println("#"+test_case+" "+ans);
		}
	}
}