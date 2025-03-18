import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static int answer, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] col = new int[N+1];
		answer = 0;
		find(col, 0);
		System.out.println(answer);
	}
	
	public static void find(int[] col , int i) {
		if (can(col, i)) {
			if ( i == N) {
				answer += 1;
				return;
			}
			for (int j = 1; j < N+1; j++) {
				col[i+1] = j;
				find(col, i+1);
			}
		}
		
	}
	
	public static boolean can(int[] col, int i) {
		boolean canF = true;
		for (int j = 1; j < i; j++) {
			if (col[j] == col[i] || Math.abs(col[j]-col[i]) == i - j) {
				canF = false;
				break;
			}
		}
		return canF;
	}
}
