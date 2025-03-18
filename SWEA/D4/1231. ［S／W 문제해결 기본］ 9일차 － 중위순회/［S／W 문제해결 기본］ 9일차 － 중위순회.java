import java.util.Scanner;

class Solution
{
	static int N;
	static String[] words;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			words = new String[N+1];
			for (int i = 1; i < N+1; i++) {
				int idx = sc.nextInt();
				words[idx] = sc.next();
				sc.nextLine();
			}
			int count = 1;
			System.out.print("#"+test_case+" ");
			inOrder(count);
			System.out.println();
		}
	}
	
	public static void inOrder(int count) {
		if (count > N) {
			return;
		}
		inOrder(2*count);
		System.out.print(words[count]);
		inOrder(2*count+1);
	}
}