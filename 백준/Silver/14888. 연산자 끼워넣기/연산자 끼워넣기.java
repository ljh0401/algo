import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int max = -1000000000;
    static int min = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        StringTokenizer mt = new StringTokenizer(br.readLine());
        int[] math = new int[4];
        for (int i = 0; i < 4; i++) math[i] = Integer.parseInt(mt.nextToken());
        int idx = 1;
        int cur = nums[0];
        find(math, nums, cur, idx, N);
        bw.write(max+"\n"+min);
        bw.flush();
        bw.close();

    }

    public static void find (int[] math, int[] nums,int cur, int idx, int N) {
        if (idx >= N) {
            if (max < cur) max = cur;
            if (min > cur) min = cur;
        }
        for (int i = 0; i <4; i++) {
            int curt = cur;
            if(math[i] == 0) continue;

            if (i == 0) curt += nums[idx];
            else if (i == 1) curt -= nums[idx];
            else if (i == 2) curt *= nums[idx];
            else curt /= nums[idx];

            math[i]--;
            find(math, nums, curt, idx+1, N);
            math[i]++;
        }
    }
}