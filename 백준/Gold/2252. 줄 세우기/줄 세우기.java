import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        List<Integer>[] line = new ArrayList[N];
        int[] sumAll = new int[N];
        if (N == 1) {
            System.out.print("1");
        }
        else {
            for (int i = 0; i < N; i++) {
                line[i] = new ArrayList<Integer>();
            }
            for (int i = 0; i < M; i++) {
                int front = sc.nextInt();
                int end = sc.nextInt();
                line[front-1].add(end-1);
                sumAll[end-1] += 1;
            }
            int idx = -1;
            int[] ans = new int[N];
            Queue<Integer> queue = new LinkedList<>();
            while(idx < N-1) {
                for (int i = 0; i < N; i++) {
                    if (sumAll[i] == 0) {
                        queue.add(i);
                        sumAll[i] -= 1;
                    }
                }
                while(!queue.isEmpty()) {
                    int tmp = queue.poll();
                    for (int num : line[tmp]) {
                        sumAll[num] -= 1;
                    }
                    ans[++idx] = tmp +1;
                }
            }
            for (int i = 0; i < N; i++) {
                System.out.print(ans[i]+" ");
            }
        }
    }
}