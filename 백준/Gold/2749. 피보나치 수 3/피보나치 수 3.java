import java.io.*;
import java.util.*;

public class Main {
	static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());
        if (n == 0) {
        	System.out.println(0);
        } else if (n == 1) {
        	System.out.println(1);
        } else {
        long half = (n+1)/2;
		long[] tmp = cal(half-1, half);
		long f1 = tmp[0];
		long f2 = tmp[1];
        long A;
        if (n % 2 == 1) {
        	A = (f2*f2 + f1*f1) % 1000000;
        } else {
        	A = (f2*f2 + 2*f1*f2) % 1000000;
        }
        System.out.print(A);
        }
    }
    
    public static long[] cal(long n1, long n2) {
    	if (n1 == 0) return new long[] {0, 1};
    	if (n1 == 1) return new long[] {1, 1};
    	long half = (n2+1)/2;
		long[] tmp = cal(half-1, half);
		long f1 = tmp[0];
		long f2 = tmp[1];
		long f_1;
		long f_2;
		if (n2 % 2 == 1) {
			f_2 = (f2*f2 + f1*f1) %1000000;
			long f_even = (f2*f2 + 2*f1*f2) % 1000000;
			f_1 = f_even-f_2;
			if (f_1 < 0) {
				f_1 = f_1 += 1000000;
			}
		} else {
			f_1 = (f2*f2 + f1*f1) %1000000;
			f_2 = (f2*f2 + 2*f1*f2) % 1000000;
		}
		return new long[] {f_1, f_2};
    }
}   	
