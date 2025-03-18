import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C, max;
    static int[] homes, dis;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        homes = new int[N];
        for (int i = 0; i < N; i++) {
        	homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        dis = new int[N-1];
        for (int i = 0; i < N-1; i++) {
        	dis[i] = homes[i+1] - homes[i];
        }
        find(0, 1000000000);
        System.out.println(max);
    }
	
	public static void find(int lo, int hi) {
		if (lo> hi) return;
		int mid = (lo+hi)/2;
		int count = 1;
		int cur = 0;
		for (int i = 0; i < N-1; i++) {
			int tmp = dis[i]+cur;
			if (tmp < mid) {
				cur += dis[i];
				continue;
			} else {
				count++;
				cur = 0;
			}
		}
		if (count >= C) {
			if (mid > max) {
				max = mid;
			}
			find(mid+1, hi);
		}
		else if (lo != hi) {
			find(lo, mid);
		} 
		return;
	}
}