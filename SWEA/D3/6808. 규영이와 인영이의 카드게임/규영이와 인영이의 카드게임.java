import java.util.Scanner;

public class Solution {
	static int win, lose;
	static int[] card, inCard;
	static boolean[] use;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test = 1; test <= T; test++) {
			card = new int[9];
			inCard = new int[9];
			use = new boolean[9];
			boolean[] in = new boolean[18];
			for (int i = 0; i < 9; i++) {
				card[i] = sc.nextInt();
				in[card[i]-1] = true;
			}
			int idx = 0;
			for (int i = 0; i <18; i++) {
				if(!in[i]) {
					inCard[idx++] = i+1;
				}
			}
			win = 0;
			lose = 0;
			find(0, 0, 0);
			System.out.println("#"+test+" "+win+" "+lose);
		}
	}
	public static void find(int count, int gu, int in) {
		if (gu > 85) {
			int idx = 1;
			for (int i = 0; i < 9-count; i++) {
				idx*=(i+1);
			}
			win += idx;
			return;
		}
		else if (in > 85) {
			int idx = 1;
			for (int i = 0; i < 9-count; i++) {
				idx*=(i+1);
			}
			lose += idx;
			return;
		}
		for (int i = 0; i < 9; i++) {
			if (!use[i]) {
				use[i] = true;
				if (inCard[i] > card[count]) {
					find(count+1, gu, in+card[count]+inCard[i]);
				}
				else {
					find(count+1, gu+card[count]+inCard[i], in);
				}
				use[i] = false;
			}
		}
	}
}