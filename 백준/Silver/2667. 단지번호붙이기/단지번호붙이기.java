import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] rD = {1,-1,0,0};
    static int[] cD = {0,0,1,-1};
    static boolean[][] MAP;
    static List<Integer> NUM = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N+2][N+2];
        for (int i = 1; i < N+1; i++) {
            String[] St = sc.next().split("");
            for (int j = 1; j < N+1; j++){
                map[i][j] = Integer.parseInt(St[j-1]);
            }
        }
        MAP= new boolean[N+2][N+2];
        int max = 0;
        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < N+1; j++) {
                if (MAP[i][j]) continue;
                MAP[i][j] = true;
                if (map[i][j] == 1){
                    max += 1;
                    NUM.add(1+find(map, i, j));
                }
            }
        }
        Collections.sort(NUM);
        System.out.println(max);
        for (int i = 0; i < NUM.size(); i++) {
            System.out.println(NUM.get(i));
        }
    }
    
    public static Integer find(int[][] map, int r, int c) {
        int round = 0;
        for (int i =0; i < 4; i++) {
            int x = r + rD[i];
            int y = c + cD[i];
            if (MAP[x][y]) {
                continue;           
            }
            if (!MAP[x][y] && map[x][y] == 1) {
                MAP[x][y] = true;
                round += 1;
                round += find(map, x, y);
            }
        }
        return round;
    }
}