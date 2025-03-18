import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] lake;
    static boolean[][] visS, visW;  
    
    static Queue<int[]> queW = new LinkedList<>(),
    				queWN = new LinkedList<>(),
    				queS = new LinkedList<>(),
    				queSN = new LinkedList<>();
    
    static int[] swan1, swan2, dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        lake = new char[R][C];
        visS = new boolean[R][C];
        visW = new boolean[R][C];

        int swanCount = 0;
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                lake[i][j] = line.charAt(j);
                if (lake[i][j] == 'L') {
                    if (swanCount == 0) {
                        swan1 = new int[]{i, j};
                    } else {
                        swan2 = new int[]{i, j};
                    }
                    swanCount++;
                    lake[i][j] = '.';
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (lake[i][j] == '.' && !visW[i][j]) {
                    visW[i][j] = true;
                    queW.offer(new int[]{i, j});
                }
            }
        }

        visS[swan1[0]][swan1[1]] = true;
        queS.offer(new int[]{swan1[0], swan1[1]});

        int days = 0;
        while (true) {
            if (moveSwan()) {
                System.out.println(days);
                return;
            }
            meltIce();
            days++;
        }
    }

    static boolean moveSwan() {
        while (!queS.isEmpty()) {
            int[] cur = queS.poll();
            int cx = cur[0], cy = cur[1];
            if (cx == swan2[0] && cy == swan2[1]) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx, ny)) continue;
                if (visS[nx][ny]) continue;

                if (lake[nx][ny] == '.') {
                    visS[nx][ny] = true;
                    queS.offer(new int[]{nx, ny});
                }
                else if (lake[nx][ny] == 'X') {
                    visS[nx][ny] = true;
                    queSN.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }

    static void meltIce() {
        while (!queW.isEmpty()) {
            int[] cur = queW.poll();
            int cx = cur[0], cy = cur[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (!inRange(nx, ny)) continue;
                if (visW[nx][ny]) continue;

                if (lake[nx][ny] == 'X') {
                    lake[nx][ny] = '.';
                    visW[nx][ny] = true;
                    queWN.offer(new int[]{nx, ny});
                }
            }
        }

        while (!queWN.isEmpty()) {
            queW.offer(queWN.poll());
        }

        while (!queSN.isEmpty()) {
            queS.offer(queSN.poll());
        }
    }

    static boolean inRange(int x, int y) {
        return (0 <= x && x < R && 0 <= y && y < C);
    }
}
