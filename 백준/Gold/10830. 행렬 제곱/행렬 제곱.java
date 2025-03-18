import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long A = Long.parseLong(st.nextToken());
        Stack<Boolean> stack = new Stack<>();
        while (A != 0) {
        	if (A%2 == 1) {
        		stack.add(false);
        		A-=1;
        	} else {
        		stack.add(true);
        		A/=2;
        	}
        }
        int[][] start= new int[N][N];
        int[][] cur = new int[N][N];
        int[][] save = new int[N][N];
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 0; j < N; j++) {
        		start[i][j] = Integer.parseInt(st.nextToken())%1000;
        		cur[i][j] = start[i][j];
        	}
        }
        if (stack.size() == 1) {
        	save = cur;
        } else {
        	stack.pop();
        	while(!stack.isEmpty()) {
        		boolean tmp = stack.pop();
        		if(tmp) {
        			for(int i = 0; i < N; i++) {
        				for (int j = 0; j < N; j++) {
        					int num = 0;
        					for (int t = 0; t < N; t++) {
        					 num += cur[i][t]* cur[t][j];	
        					}
        					save[i][j] = num%1000;
        				}
        			}
        		} else {
        			for(int i = 0; i < N; i++) {
        				for (int j = 0; j < N; j++) {
        					int num = 0;
        					for (int t = 0; t < N; t++) {
        					 num += cur[i][t]* start[t][j];	
        					}
        					save[i][j] = num%1000;
        				}
        			}
        		}
        		for(int i = 0; i < N; i++) {
    				for (int j = 0; j < N; j++) {
    					cur[i][j] = save[i][j];
    				}
    			}
        	}        	
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(cur[i][j]+" ");
			}
			sb.append("\n");
		}
        System.out.print(sb);
    }
}