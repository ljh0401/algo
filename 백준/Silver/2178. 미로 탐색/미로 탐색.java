import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] rD = {1,-1,0,0};
    static int[] cD = {0,0,1,-1};
    static int N,M;
    static int[][] MAP;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int[][] map = new int[N+2][M+2];
        MAP= new int[N+2][M+2];
        for (int i = 1; i < N+1; i++) {
            String[] St = sc.next().split("");
            for (int j = 1; j < M+1; j++){
                map[i][j] = Integer.parseInt(St[j-1]);
                MAP[i][j] = 100000;
            }
        }
        MAP[1][1] = 1;
        int r = 1;
        int c = 1;
        List<Integer> SAVE = new ArrayList<>();
        SAVE.add(1);
        SAVE.add(1);
        while (true) {
            List<Integer> copy = new ArrayList<>();
            for (int i = 0; i < SAVE.size()/2; i++) {
            copy.addAll(current(map, SAVE.get(2*i), SAVE.get(2*i+1)));
            }
            if (MAP[N][M] != 100000) {
                break;
            }
            SAVE.addAll(copy);            
        }
        System.out.print(MAP[N][M]);
    }

    public static List<Integer> current (int[][]map, int r, int c) {
        List<Integer> save = new ArrayList<>(); 
        for (int s =0; s < 4; s++) {
            int x = r + rD[s];
            int y = c + cD[s];
            if (MAP[x][y] != 100000) {
                continue;           
            }
            else if (map[x][y] == 1) {
                MAP[x][y] = MAP[r][c] + 1;
                save.add(x);
                save.add(y);
            }
        }
        return save;
                
    }
}