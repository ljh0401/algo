import java.util.*;
import java.lang.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int num = 1;
        int idx = 0;
        int sum = 0;
        A:
        while(true) {
            for (int i = 0; i < num; i++) {
                idx++;
                if(idx >= A && idx <= B) {
                    sum += num;
                }
                if (idx >B) break A;
            }
            num++;
        }
        System.out.println(sum);
    }
}