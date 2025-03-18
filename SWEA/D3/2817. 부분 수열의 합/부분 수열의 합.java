import java.util.Scanner;

public class Solution {
	static int answer, N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			answer = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			int[] arr = new int[N];
			for (int i = 0 ; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 1; i < 1 << N; i++) {
				int sum = 0;
				for (int j = 0; j < N; j++) {
					if ((i & 1 << j) > 0) sum +=arr[j]; 
				}
				if (sum == K)
					answer += 1;
			}
			System.out.println("#"+test+" "+answer);
		}
	}
}