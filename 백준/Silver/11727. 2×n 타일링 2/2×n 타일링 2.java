import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int[] nums = new int[1001];
	static {
		nums[1] = 1;
		nums[2] = 3;
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());
		int answer = 0;
		if (nums[A] == 0) {
			for (int i = 3; i < A+1; i++) {
				if (nums[i] != 0) continue;
				nums[i] = (nums[i-1] + nums[i-2]*2)%10007;
			}
		}
		answer = nums[A];
		System.out.println(answer);
	}
}