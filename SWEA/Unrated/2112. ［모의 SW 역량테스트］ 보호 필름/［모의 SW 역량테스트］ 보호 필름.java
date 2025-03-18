import java.util.Scanner;

public class Solution {

    static int D, W, K, answer;
    static int[][] film;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 1; t <= T; t++) {
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();
            film = new int[D][W];
            
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < W; j++) {
                    film[i][j] = sc.nextInt();
                }
            }
            
            if (K == 1 || checkFilm(film)) {
                System.out.println("#" + t + " " + 0);
                continue;
            }
            
            answer = K;
            dfs(0, 0, film);
            System.out.println("#" + t + " " + answer);
        }
    }

    static void dfs(int idx, int cnt, int[][] currentFilm) {
        if (cnt >= answer) return;
        if (checkFilm(currentFilm)) {
            answer = cnt;
            return;
        }
        if (idx == D) return;
        int[] backup = currentFilm[idx];
        dfs(idx + 1, cnt, currentFilm);
        int[] newRow = new int[W];
        currentFilm[idx] = newRow;
        dfs(idx + 1, cnt + 1, currentFilm);
        newRow = new int[W];
        for (int i = 0; i < W; i++) {
            newRow[i] = 1;
        }
        currentFilm[idx] = newRow;
        dfs(idx + 1, cnt + 1, currentFilm);
        currentFilm[idx] = backup;
    }
    
    static boolean checkFilm(int[][] film) {
        for (int j = 0; j < W; j++) {
            int count = 1;
            boolean valid = false;
            for (int i = 1; i < D; i++) {
                if (film[i][j] == film[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                if (count >= K) {
                    valid = true;
                    break;
                }
            }
            if (!valid) return false;
        }
        return true;
    }
}
