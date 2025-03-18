import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int ans = 0;
			int N = sc.nextInt();
			String[][] words = new String[8][8];
			for (int i = 0; i < 8 ; i++) {
				words[i] = sc.next().split("");
			}
			for (int i = 0; i < 8 ; i++) {
				for (int j = 0; j <= 8-N ; j++) {
					int rFind = 0;
					int cFind = 0;
					for (int s = 0; s < N/2; s++) {
						if (words[i][j+s].equals(words[i][j+N-1-s])) {
							rFind += 1;
						}
						if (words[j+s][i].equals(words[j+N-1-s][i])) {
							cFind += 1;
						}
					}
					if (rFind == N/2) ans+=1;
					if (cFind == N/2) ans+=1;
				}
			}
			System.out.println("#"+test_case+" "+ans);
		}
	}
}