import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i <T; i++) {
			int N = sc.nextInt();
			int j = 0;
			while (N!=0) {
				if (N%2 == 1) System.out.print(j+" ");;
				j++;
				N /= 2;
			}
		}
	}
}