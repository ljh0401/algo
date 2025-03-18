import java.io.*;
import java.util.*;

public class Main {
	static int[][][] map = new int[101][10][1024];
	static int mod =1000000000;
	
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    if(map[n][1][2] == 0) {
	    	if (map[1][1][2] == 0) {
	    		map[1][1][2] = 1;
	    		map[1][2][4] = 1;
	    		map[1][3][8] = 1;
	    		map[1][4][16] = 1;
	    		map[1][5][32] = 1;
	    		map[1][6][64] = 1;
	    		map[1][7][128] = 1;
	    		map[1][8][256] = 1;
	    		map[1][9][512] = 1;
	    	}
	    	for (int i = 2; i <= n; i++) {
	    		if (map[i][1][2] == 0) {
	    			make(i);
	    		}
	    	}
	    	int answer = sum(n);
	    	System.out.print(answer);
	    }
	    else {
	    	int answer = sum(n);
	    	System.out.print(answer);
	    }
    }   	
    public static int sum(int n) {
    	int answer = 0;
    	for(int i = 0; i < 10; i++) {
    		answer = (answer + map[n][i][1023])%mod;
    	}
    	return answer;
    }
    
    public static void make(int n) {
		for (int j = 0; j < 10; j++ ) {
    		for (int t= 1; t < 1024; t++) {
    			int nxtBit = t | (1 << j);
    			if (j > 0)
    				map[n][j][nxtBit] += map[n-1][j-1][t];
    			if (j < 9)
    				map[n][j][nxtBit] += map[n-1][j+1][t];
    			map[n][j][nxtBit] %= mod;
    		}
    	}
    }
}
