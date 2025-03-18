import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] sang = new int[N][2];
        for (int i = 0;i < N ; i++) {
            for(int j = 0; j < 2; j++) {
                sang[i][j] = sc.nextInt();
            }
        }
        int[] day = new int[N+1];
        for (int i=0; i < N; i++) {
            if ((i+1) < N+1 && (day[i+1] < day[i] || day[i+1] == 0)) {
                day[i+1] = day[i];
            }
            if (i + sang[i][0] >= N+1 ) {
                continue;
            }
            if (day[i] + sang[i][1] > day[i + sang[i][0]]) {
                day[i + sang[i][0]] = day[i] + sang[i][1];
            }
        }
        System.out.print(day[N]);
    }
}