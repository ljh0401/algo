import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] N_K = new int[K];
        int j = 0;
        for(int i = 1; i <= N; i++) {
            if (N_K[K-1] != 0) break;
            if (N%i == 0) {
                N_K[j] = i;
                j++;
            }
        }
        System.out.print(N_K[K-1]);
    }
}