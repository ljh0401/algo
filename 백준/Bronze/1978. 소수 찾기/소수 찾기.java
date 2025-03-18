import java.util.*;
import java.lang.Math;

class Main {

    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i < Math.sqrt(num)+1; i++) {
            if(num == 2) break;
            if(num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int prime = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (isPrime(num)) prime++;
        }
        System.out.print(prime);
    }
}