import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int know = Integer.parseInt(st.nextToken());
		boolean[] people = new boolean[N+1];
		int answer =0;
		if (know != 0) {
			for (int i = 0; i < know; i++) {
				people[Integer.parseInt(st.nextToken())] = true;
			}
			boolean[] party = new boolean[M];
			boolean[][] pp = new boolean[M][N+1];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int tmp = Integer.parseInt(st.nextToken());
				for (int j = 0; j < tmp; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (people[num]) party[i] = true;
					pp[i][num] = true;
				}
			}
			Queue<Integer> que = new LinkedList<>();
			for (int i = 0; i < M; i++) {
				if (party[i]) {
					for (int j = 1; j < N+1; j++) {
						if (pp[i][j]) {
							if (!people[j]) {
								que.add(j);
								people[j] = true;
							}
						}
					}
				}
			}
			while (!que.isEmpty()) {
				int tmp = que.poll();
				for (int i = 0; i < M; i++) {
					if (!party[i]) {
						if (pp[i][tmp]) {
							for (int j = 1; j < N+1; j++) {
								if (pp[i][j]) {
									if (!people[j]) {
										que.add(j);
										people[j] = true;
									}									
								}
							}
							party[i] =true;
						}
					}
				}
			}
			for (int i = 0; i < M; i++) {
				if (!party[i]) answer++;
			}
		}
		else {
			answer = M;
		}
		System.out.print(answer);
	}
}