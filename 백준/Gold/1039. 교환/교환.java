import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int len = N.length();
        if (len < 2) {
            System.out.println(-1);
            return;
        }
        Set<String> cur = new HashSet<>();
        cur.add(N);
        for (int k = 0; k < K; k++) {
            Set<String> next = new HashSet<>();
            for (String s : cur) {
                char[] arr = s.toCharArray();
                for (int i = 0; i < len - 1; i++) {
                    for (int j = i + 1; j < len; j++) {
                        swap(arr, i, j);
                        if (arr[0] != '0') {
                            next.add(new String(arr));
                        }
                        swap(arr, i, j);
                    }
                }
            }
            if (next.isEmpty()) {
                System.out.println(-1);
                return;
            }
            cur = next;
        }

        int answer = -1;
        for (String s : cur) {
            answer = Math.max(answer, Integer.parseInt(s));
        }
        System.out.println(answer);
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
