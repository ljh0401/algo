import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        int max = 0;
        int inT = 0;
        for (int i = 0; i < T; i++) {
        int n = sc.nextInt();
        int t = sc.nextInt();
        inT = inT-n+t;
        if (inT > max) max = inT;
        }
        System.out.print(max);
    }
}