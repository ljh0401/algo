import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        Long answer = 1L;
        while(B != 0) {
            if (B % 2 == 1) {
                answer = (answer*A)%C;
            }
            B /= 2;
            A = (A*A)%C;
        }
        System.out.print(answer);
    }
}