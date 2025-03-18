import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int D = 4;
        for (int i = 0; i < N; i++){
            D += Math.pow(4, i)*5;
            if (i >0){
                D -= Math.pow(2, i)*(Math.pow(2, i)-1)*2;
            }
        }
        System.out.print(D);
    }
}