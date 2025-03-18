import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S =Integer.parseInt(st.nextToken());
        StringTokenizer stt = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(stt.nextToken());
        }
        int minIdx = 100001;
        int sum = 0;
        int idx = 0;
        
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            
            while (sum >= S) {
                minIdx = Math.min(minIdx, i - idx + 1);
                sum -= nums[idx++];
            }
        }
        if (minIdx == 100001) {
            bw.write(""+0);
        } 
        else {
            bw.write(""+minIdx);       
        }
        bw.flush();
        bw.close();
    }
}