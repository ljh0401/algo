import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
            int b = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
            int c = (int) Math.pow(Integer.parseInt(st.nextToken()), 2);
            if (a+b+c == 0) break;
            if (a > b && a > c) {
                if (a == b+c) {
                    System.out.println("right");
                    continue;
                }
                else {
                    System.out.println("wrong");
                    continue;
                }
            }
            else if (b > a && b > c) {
                if (b == a+c) {
                    System.out.println("right");
                    continue;
                }
                else {
                    System.out.println("wrong");
                    continue;
                }
            }
            else {
                if (c == b+a) {
                    System.out.println("right");
                    continue;
                }
                else {
                    System.out.println("wrong");
                    continue;
                }
            }
        }
    }
}