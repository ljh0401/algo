import java.util.Scanner;
import java.util.PriorityQueue;

class Solution
{
	static Scanner sc = new Scanner(System.in);
	static int N;
	static PriorityQueue<Integer> queue;
	public static void main(String args[]) throws Exception
	{
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            N = sc.nextInt();
            queue = new PriorityQueue<>((a, b) -> {return b-a;});
            System.out.print("#"+test_case);
            for (int i = 0; i < N; i++) {
            	int tmp = sc.nextInt();
            	if (tmp == 1) {
            		method1();
            	}
            	else {
            		method2();
            	}
            }
            System.out.println();
		}
	}
	
	public static void method1() {
		queue.add(sc.nextInt());
	}
	
	public static void method2() {
		if (queue.isEmpty()) {
			System.out.print(" -1");
		}
		else {
			System.out.print(" "+queue.poll());
		}
		
	}
}