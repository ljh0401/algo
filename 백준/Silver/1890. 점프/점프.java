import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        long[][] find = new long[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        find[0][0] = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (find[i][j] > 0) {
                    int step = map[i][j];
                    if ( i == N-1 && j == N-1) {
                        break;
                    }
                    else if (map[i][j] == 0) {
                        continue;
                    }
                    if (j + step < N) {
                        find[i][j + step] += find[i][j];
                    }
                    if (i + step < N) {
                        find[i + step][j] += find[i][j];
                    }
                }
            }
        }
        System.out.print(find[N-1][N-1]);
    }
}