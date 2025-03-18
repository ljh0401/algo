import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = -100;
        int[] nan = new int[9];
        int[] ans = new int[7];
        for (int i = 0; i < 9; i++) {
            nan[i] = sc.nextInt();
            sum += nan[i];
        }
        Arrays.sort(nan);
        int stop = 0;
        A:
        for (int i = 0; i < 9; i++) {
            int find = sum - nan[i];
            for (int j = i+1; j < 9; j++) {
                int tmp = find - nan[j];
                if (tmp == 0) {
                    for (int s = 0; s < 9; s++) {
                        if (stop == 7) break A;
                        if (s != i && s != j) {
                            System.out.println(nan[s]);
                            stop++;
                        }
                    }
                }
            }
        }
    }
}