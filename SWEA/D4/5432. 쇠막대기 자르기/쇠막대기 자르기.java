import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T=sc.nextInt();
		
		// T번의 테스트 케이스 반복
		for(int test_case = 1; test_case <= T; test_case++)
		{
			List<String> iron = Arrays.asList(sc.next().split(""));
			int idx = -1;
			int ans = 0;
			for (int i = 0; i < iron.size(); i++) {
				if (i < iron.size()-1 && iron.get(i).equals("(") && iron.get(i+1).equals(")")) {
					ans += (idx+1);
					i += 1;
					continue;
				}
				if (iron.get(i).equals("(")) {
					idx += 1;
				}
				else if (iron.get(i).equals(")")) {
					ans += 1;
					idx -= 1;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
}
