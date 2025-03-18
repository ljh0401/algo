import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((a, b) -> b-a);
		int size = 2;
		int num1 = Integer.parseInt(br.readLine());
		int num2 = Integer.parseInt(br.readLine());
		bw.write(num1+"\n");
		if(num1 > num2) {
			pq1.add(num1);
			pq2.add(num2);
			bw.write(num2+"\n");
		}
		else {
			pq1.add(num2);
			pq2.add(num1);
			bw.write(num1+"\n");
		}
		int pq1S = 1;
		int pq2S = 1;
		for (int i = 2; i < N; i++) {
			size++;
			int num = Integer.parseInt(br.readLine());
			if (pq1.peek() < num) {
				pq1S++;
				pq1.add(num);
				if (size % 2 == 1) {
					if (pq1S - pq2S > 1) {
						pq2.add(pq1.poll());
						pq1S--;
						pq2S++;
					}
					bw.write(pq1.peek()+"\n");						
				}
				else {
					while(!(pq1S == pq2S)) {
						pq2.add(pq1.poll());
						pq1S--;
						pq2S++;
					}
					bw.write(Math.min(pq1.peek(), pq2.peek())+"\n");
				}
			}
			else if (pq2.peek() > num) {
				pq2S++;
				pq2.add(num);
				if (size % 2 == 1) {
					if (pq2S - pq1S > 1) {
						pq1.add(pq2.poll());
						pq2S--;
						pq1S++;
					}
					bw.write(pq2.peek()+"\n");
				}
				else {
					while(!(pq1S == pq2S)) {
						pq1.add(pq2.poll());
						pq2S--;
						pq1S++;
					}
					bw.write(Math.min(pq1.peek(), pq2.peek())+"\n");
				}
			}
			else {
				if(pq2S <= pq1S) {
					pq2.add(num);
					pq2S++;
				}
				else if (pq2S > pq1S) {
					pq1.add(num);
					pq1S++;
				}
				if (size % 2 == 1) {
					bw.write(num+"\n");
				}
				else {
					bw.write(Math.min(pq1.peek(), pq2.peek())+"\n");
				}	
			}
		}
		bw.flush();
		bw.close();
	}
}
