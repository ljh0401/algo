import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int answer = -1;
        int count = 1;
        while(first != end && end != 1) {
            if(end % 10 == 1) {
                end = end/10;
            }
            else if(end % 2 != 0) {
                break;
            }
            else {
                end = end/2;
            }
            count++;
        }
        if (first == end) {
            answer = count;
        }
        System.out.print(answer);
    }
}