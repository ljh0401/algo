import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] rD = {1,-1,0,0};
    static int[] cD = {0,0,1,-1};
    static boolean[][] MAP;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] map = new int[N+2][M+2];
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1;
        }
        MAP= new boolean[N+2][M+2];
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < M+1; j++) {
                if (MAP[i][j]) continue;
                MAP[i][j] = true;
                if (map[i][j] == 1){
                    int ans = 1;
                    ans += find(map, i, j);
                    if (max < ans) {
                        max = ans;
                    }
                }
            }
        }
        System.out.print(max);
    }
    
    public static Integer find(int[][] map, int r, int c) {
        int round = 0;
        for (int i =0; i < 4; i++) {
            int x = r + rD[i];
            int y = c + cD[i];
            if (map[x][y] == 0) continue;
            if (!MAP[x][y] && map[x][y] == 1) {
                MAP[x][y] = true;
                round += 1;
                round += find(map, x, y);
            }
        }
        return round;
    }
}