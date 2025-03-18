import java.util.Scanner;


class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int N = sc.nextInt();
            sc.nextLine();
            String[][] OM = new String[N][N];
            for (int i = 0 ; i < N; i++) {
                OM[i] = sc.nextLine().split("");
            }
            int[] r ={0, 0, -1, -1, -1};
            int[] c = {1, -1, 0,  1, -1};
            String as = "NO";
            for (int j = 0; j <N; j++) {
                if (as.equals("YES")) break;
                for (int k = 0; k < N; k++){
                    if (as.equals("YES")) break;
                    if (OM[j][k].equals("o")){
                        for (int s = 0; s <5; s++){
                            if (as.equals("YES")) break;
                            int rr = r[s] + j;
                            int cc = c[s] + k;
                            int om = 1;
                            while (cc >=0 && cc<N && rr >=0 && rr<N && om != 5) {
                            	if (OM[rr][cc].equals(".")) break;
                                rr += r[s];   
                                cc += c[s];
                                om += 1;
                                }
                           if (om == 5) as = "YES";
                            }
                            }
                        }
                    }
            System.out.println("#"+test_case+" "+as);
		}
	}
}