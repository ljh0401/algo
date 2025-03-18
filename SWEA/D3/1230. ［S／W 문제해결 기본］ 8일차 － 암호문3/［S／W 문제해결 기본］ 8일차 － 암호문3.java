import java.util.Scanner;
import java.util.List;
import java.util.LinkedList;

class Solution
{
	static Scanner sc = new Scanner(System.in);
	static List<Integer> list;
	public static void main(String args[]) throws Exception
	{
		
		int T = 10;
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(sc.nextInt());
			}
			int M = sc.nextInt();
			for (int i = 0; i < M; i++) {
				String word = sc.next();
				if (word.equals("I")) {
					I();
				}
				else if (word.equals("D")) {
					D();
				}
				else if (word.equals("A")) {
					A();
				}
			}
			System.out.print("#"+test_case);
			for (int i = 0; i < 10; i++) {
				System.out.print(" "+list.get(i));
			}
			System.out.println();
		}
	}
	
	public static void I() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < y; i++) {
			list.add(x+i, sc.nextInt());
		}
	}
	
	public static void D() {
		int x = sc.nextInt();
		int y = sc.nextInt();
		for (int i = 0; i < y; i++) {
			list.remove(x);
		}
	}
	
	public static void A() {
		int y = sc.nextInt();
		for (int i = 0; i < y; i++) {
			list.add(sc.nextInt());
		}
	}
}