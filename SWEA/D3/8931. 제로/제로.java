import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		// T번의 테스트 케이스 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt();
			long sum = 0;
			List<Integer> money = new ArrayList<>();
			int idx = -1;
			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				if (num == 0) {
					sum -= money.get(idx);
					money.remove(idx);
					idx--;
					continue;
				}
				sum += num;
				idx++;
				money.add(num);
			}
			
			// 정답 출력
			System.out.println("#"+test_case+" "+sum);
		}
	}
}