
import java.io.*;
import java.util.*;

public class Main {
	static int[] Dc = {1, -1, 0, 0};
	static int[] Dr = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				stack.add(Integer.parseInt(st.nextToken()));
			}
			else if (num == 2) {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.pop()+"\n");
				}
			}
			else if (num == 3) {
				sb.append(stack.size()+"\n");
			}
			else if (num == 4) {
				if(stack.isEmpty()) {
					sb.append("1\n");
				}
				else {
					sb.append("0\n");
				}
			}
			else {
				if (stack.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(stack.peek()+"\n");
				}
			}
		}
		System.out.print(sb);
	}
}