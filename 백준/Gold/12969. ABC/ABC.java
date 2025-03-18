import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, K;
    static boolean[][][][] data;
    static StringBuilder sb;
    static int[] words;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new int[N];
        data = new boolean[N+1][N+1][N+1][(N*N+1/2)];
        if (!find(0, 0, 0, 0)) {
            System.out.print("-1");
        }
        else {
            sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                switch (words[i]) {
                    case 1:
                        sb.append("A");
                        break;
                    case 2:
                        sb.append("B");
                        break;
                    case 3:
                        sb.append("C");
                        break;
                }
            }
            System.out.print(sb);
        }
    }
    
    public static boolean find(int a, int b, int idx, int count) {
        if (data[a][b][idx][count]) return false;
        if (count > K) {
            data[a][b][idx][count] = true;
            return false;
        }
        if (idx ==N) {
            if (count == K) {
                return true;
            }
            return false;
        }
        for (int i = 1; i <= 3; i++) {
            words[idx] = i;
            boolean find = false;
            if (i == 1) {
                find = find(a+1, b, idx+1, count);
            }
            else if (i == 2) {
                find = find(a, b+1, idx+1, count+a);
            }
            else {
                find = find(a, b, idx+1, count+a+b);
            }
            if (find) return true;
        }
        data[a][b][idx][count] = true;
        return false;
    }
}