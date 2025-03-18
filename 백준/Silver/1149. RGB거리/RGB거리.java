import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sum = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j< 3; j++) {
            sum[j] += Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N-1; i++) {
            int[] tmp = new int[3];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j< 3; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            tmp[0] += Math.min(sum[1], sum[2]);
            tmp[1] += Math.min(sum[0], sum[2]);
            tmp[2] += Math.min(sum[0], sum[1]);
            sum[0] = tmp[0];
            sum[1] = tmp[1];
            sum[2] = tmp[2];
        }
        int answer = Math.min(sum[0], Math.min(sum[1], sum[2]));
        System.out.print(answer);
    }
}