import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		int nums[][] = new int[s1.length()][s2.length()];
		int tmp = 0;
		for (int i = 0; i < s2.length(); i++) {
			if (s1.charAt(0) == s2.charAt(i)) {
				tmp = 1;
			}
			nums[0][i] = tmp;
		}
		for (int i = 1; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				int max = nums[i-1][j];
				if (j == 0 && s1.charAt(i) == s2.charAt(j)) {
					nums[i][j] = 1;
				}
				else if (s1.charAt(i) == s2.charAt(j)) {
					nums[i][j] = nums[i-1][j-1] +1;
				}
				max = Math.max(max, nums[i][j-1 >= 0? j-1:0]);
				nums[i][j] =  Math.max(max, nums[i][j]);
			}
		}
		System.out.println(nums[s1.length()-1][s2.length()-1]);
	}
}