import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int A = 0;
        int B = 0;
        int max = a*b;
        if (a > b) {
            A = a;
            B = b;
        }
        else {
            A = b;
            B = a;
        }
        int[] C = new int[A+1];
        int num = 2;
        while (A != 0) {
            if (A%num == 1 && A/num == 0) break;
            if (A%num == 0) {
                A /= num;
                C[num] += 1;
            }
            else if (A%num != 0) {
                num++;
            }
        }
        int min = 1;
        num = 2;
        while (B != 0){
            if (B%num == 1 && B/num == 0) break;
            if (B%num == 0) {
                B /= num;
                if (C[num] > 0) {
                    min *= num;
                }
                C[num] -= 1;
            }
            else if (B%num != 0) {
                num++;
            }
        }
        max /= min;
        System.out.println(min);
        System.out.println(max);
    }
}