import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        boolean[] nums = new boolean[10001];
        nums[0] = true;
        nums[1] = true;
        for (int i = 2; i < 100; i++) {
            if (nums[i] == true) continue;
            int j = 2;
            while(true) {
                if (i*j >10000) break;
                nums[i*j] = true;
                j++;
            }
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long sum = 0;
        int min = 10001;
        for (int j = M; j <= N; j++) {
            if (nums[j] == true) continue;
            sum += j;
            if (min > j) min = j;
        }
        if (sum == 0 && min == 10001) bw.write("-1");
        else bw.write(sum+"\n"+min);
        bw.flush();
        bw.close();

    }
}