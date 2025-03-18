import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        int f = 0;
        int d = 1;
        if (n == 0) System.out.println(f);
        if (n == 1) System.out.println(d);
        while(i <= n) {
            f = f + d;
            i += 1;
            if (i == n) {
                 System.out.println(f);
                break;  
            }
            d = f + d;
            i += 1;
            if (i == n) {
                 System.out.println(d);
                break;  
            }
        }
    }
}