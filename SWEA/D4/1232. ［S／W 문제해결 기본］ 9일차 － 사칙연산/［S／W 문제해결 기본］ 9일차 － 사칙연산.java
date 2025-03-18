import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

class Solution
{
	static int N;
	static List<String> words;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			words = new LinkedList<>();
            for (int i =0; i < N; i++ ) {
                words.add("#"+sc.next());
                String w = sc.next();
                Character word = w.charAt(0);
                words.add(w);
                if (word == '-' || word == '+' || word == '*' || word == '/') {
                    words.add(sc.next());
                    words.add(sc.next());
                }
            }
			
			int ans = (int) postOrder(0);
			System.out.println("#"+test_case+" "+ans);
		}
	}
	
	public static double postOrder(int count) {
		String word = words.get(count);
        if(word.charAt(0) == '#'){
            if (words.get(count+1).equals("-")) {
                
    			double num1 = postOrder(words.indexOf("#"+words.get(count+2)));
    			double num2 = postOrder(words.indexOf("#"+words.get(count+3)));
    			return num1 - num2;
    		}
    		else if (words.get(count+1).equals("+")) {
    			double num1 = postOrder(words.indexOf("#"+words.get(count+2)));
    			double num2 = postOrder(words.indexOf("#"+words.get(count+3)));
    			return num1 + num2;
    		}
    		else if (words.get(count+1).equals("*")) {
    			double num1 = postOrder(words.indexOf("#"+words.get(count+2)));
    			double num2 = postOrder(words.indexOf("#"+words.get(count+3)));
    			return num1 * num2;
    		}
    		else if (words.get(count+1).equals("/")) {
    			double num1 = postOrder(words.indexOf("#"+words.get(count+2)));
    			double num2 = postOrder(words.indexOf("#"+words.get(count+3)));
    			return num1 / num2;
    		}
            else {
                return (double) Integer.parseInt(words.get(count+1));
            }
        }
        else {
            return (double) Integer.parseInt(word);
        }
	}
}