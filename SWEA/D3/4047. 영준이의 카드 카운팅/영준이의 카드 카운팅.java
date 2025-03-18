import java.util.Scanner;
import java.io.FileInputStream;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        A:
		for(int test_case = 1; test_case <= T; test_case++)
		{
            System.out.print("#"+test_case+" ");
			String[] card = sc.next().split("");
            int S = 13;
            int D = 13;
            int H = 13;
            int C = 13;
            int c = card.length/3;
            String[] deck = new String[c];
            for (int i = 0; i < c; i++) {
                for (int j =0; j < 3; j++) {
                    if (deck[i] == null) {
                        deck[i] = card[3*i+j];
                        if (deck[i].equals("S")) S--;
                        else if (deck[i].equals("D")) D--;
                        else if (deck[i].equals("H")) H--;
                        else if (deck[i].equals("C")) C--;
                    }
            		else deck[i] +=card[3*i+j];
                }
            }
            for (int i = 0; i < c; i++) {
            	for (int j = 0; j < c; j++) {
                    if (i == j) continue;
                	if (deck[i].equals(deck[j])) {
                        System.out.println("ERROR");
                        continue A;
                    }
                }
            }
            System.out.println(S+" "+D+" "+H+" "+C);
		}
	}
}