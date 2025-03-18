import java.util.*;

class Solution {
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test = 1; test <= T; test++) {
            int day = sc.nextInt();
            int mon = sc.nextInt();
            int mon3 = sc.nextInt();
            int year = sc.nextInt();
            int[] use = new int[13];
            for (int i = 1; i < 13; i++) {
                use[i] = sc.nextInt();
            }
            int[] min = new int[13];
            int calY = year;
            int answer = -1;
            for (int i = 1; i < 13; i++) {
                int calD = min[i-1] + day*use[i];
                int calM = min[i-1] + mon;
                int calM3 = mon3;
                if (i >= 3) {
                	calM3 = min[i-3]+mon3;
                }
                else if (i == 2) {
                	calM3 = min[i-2]+mon3;
                }
                min[i] = Math.min(calD, Math.min(calM, Math.min(calM3, calY)));
                if (min[i] == calY) {
                	answer = calY;
                    break;
                }	
            }
            if (answer == -1) {
            	answer = min[12];
            }
            System.out.println("#"+test+" "+answer);
        }
    }
}