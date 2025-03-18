import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    static int startC, lastC, M, N;
    static int min = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        List<int[]>[] buses = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            buses[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            String[] St = br.readLine().split(" ");
            int[] nums = {Integer.parseInt(St[1]),Integer.parseInt(St[2])};
            buses[Integer.parseInt(St[0])].add(nums);
        }
        String[] St2 = br.readLine().split(" ");
        startC = Integer.parseInt(St2[0]);
        lastC = Integer.parseInt(St2[1]);
        int[] minFind = find(startC, buses);
        if (minFind[lastC] == 1000000000) {
            bw.write(""+-1);
        }
        else {
            bw.write(""+minFind[lastC]);
        }
        bw.flush();
        bw.close();
    }
    public static int[] find (int startC, List<int[]>[] buses) {
        int[] minMoney = new int[N+1];
        boolean[] visited = new boolean[N+1];
        Arrays.fill(minMoney, 1000000000);
        minMoney[startC] = 0;
        while(true) {
            int FIND = 1000000000;
            int idx = -1;
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && minMoney[i] < FIND) {
                    FIND = minMoney[i];
                    idx = i;
                }
            }
            if (idx == -1) break;
            visited[idx] = true;
            for (int[] edge : buses[idx]) {
                int next = edge[0];
                int cost = edge[1];
                if (minMoney[idx] + cost < minMoney[next]) {
                    minMoney[next] = minMoney[idx] + cost;
                }
            }
        }
        return minMoney;
    }
}