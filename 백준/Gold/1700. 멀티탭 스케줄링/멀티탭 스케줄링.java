import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] input;
    static int[] plug;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        input = new int[K];
        plug = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        int idx;
        A:
        for (int i = 0; i < K; i++) {
            int tmp = input[i];
            for(int j = 0; j < N; j++) {
                if (plug[j] == tmp) continue A;
                else if (plug[j] == 0) {
                    plug[j] = tmp;
                    continue A;
                }
            }
            int poll = -1;
            int curr = -1;
            for(int j = 0; j < N; j++) {
                int nidx = -1;
                int cur = plug[j];
                for (int t = i+1; t < K; t++) {
                    if (cur == input[t]) {
                       nidx = t-i;
                       break;
                    }
                }
                if (nidx == -1) {
                    plug[j] = tmp;
                    answer += 1;
                    continue A;
                } 
                if (poll < nidx) {
                    poll = nidx;
                    curr = j;
                }
            }
            plug[curr] = tmp;
            answer+=1;
        }
        System.out.print(answer);
    }
}