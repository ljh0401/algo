import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] inc = new int[N];
        int[] dec = new int[N];
        inc[0] = 1;
        dec[N-1] = 1;
        int[] input = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	input[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i < N; i++) {
        	int maxI = 1;
        	int maxD = 1;
        	for (int j = 0; j < i; j++) {
        		if (input[j] < input[i]) {
        			maxI = Math.max(maxI, inc[j]+1);
        		} 
        		if (input[N -1 -j] < input[N -1 -i]) {
        			maxD = Math.max(maxD, dec[N -1 -j]+1);
        		}
        	}
        	inc[i] = maxI;
        	dec[N-1-i] = maxD;
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
        	max = Math.max(max, inc[i]+dec[i]-1);
        }
        System.out.print(max);
    }
}