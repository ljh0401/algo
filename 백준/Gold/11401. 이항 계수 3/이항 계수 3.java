import java.io.*;
import java.util.*;

public class Main {
    static int N, K, num = 1000000007;;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K > N/2) {
        	K = N-K;
        }
        
        long a = 1;
        long b = 1;
        if (K == 0) {
        	System.out.println(1);
        }
        else {
        for (int t = 0; t < K; t++) a = a * (N-t) % num;
        for (int i = 1; i < K+1; i++) b = b * i % num;
        System.out.println(multi(b, num-2)% num *a % num);
        }
    }
    
    public static long multi(long b, long pow) {
    	if (pow == 1) return b;
    	long tmp = multi(b, pow/2);
    	if (pow % 2 == 1) {
    		return (tmp*tmp%num)*b%num;
    	}
    	return tmp*tmp%num;
    }
}
