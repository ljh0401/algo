import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T;
			T=sc.nextInt();
			String target = sc.next();
			String word = sc.next();
			word = "*"+word+"*";
			String[]Word = word.split(target);
			int ans = Word.length-1;
			System.out.println("#"+test_case+" "+ans);
		}
	}
}