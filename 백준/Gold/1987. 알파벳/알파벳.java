import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static char[][] cha;
    static boolean[] vis;
    static int R, C;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        cha = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                cha[i][j] = tmp.charAt(j);
            }
        }
        vis = new boolean['Z'-'A'+1];
        dfs(0, 0, 1);
        System.out.print(max);
    }

    public static void dfs(int r, int c, int step) {
        vis[cha[r][c] - 'A'] = true;
        if (r-1 >= 0 && !vis[cha[r-1][c] - 'A']) {
            dfs(r-1, c, step+1);
            vis[cha[r-1][c] - 'A'] = false;
        }
        if (r+1 < R && !vis[cha[r+1][c] - 'A']) {
            dfs(r+1, c, step+1);
            vis[cha[r+1][c] - 'A'] = false;
        }
        if (c-1 >= 0 && !vis[cha[r][c-1] - 'A']) {
            dfs(r, c-1, step+1);
            vis[cha[r][c-1] - 'A'] = false;
        }
        if (c+1 < C && !vis[cha[r][c+1] - 'A']) {
            dfs(r, c+1, step+1);
            vis[cha[r][c+1] - 'A'] = false;
        }
        if (max < step) max = step;
    }
}