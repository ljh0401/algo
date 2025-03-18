import java.util.*;

class Main {
    static int K, N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        K = sc.nextInt();
        N = K - 5;
        int idx = 0;
        if (K <= 4) {
            System.out.print("0");
            return;
        }
        int ans = 0;
        Set<String> all = new HashSet<>();
        List<Set<String>> wordList = new ArrayList<>();
        
        for (int test = 0; test < T; test++) {
            Set<String> wordSet = new HashSet<>();
            String word = sc.next();
            for (char ch : word.toCharArray()) {
                if (ch == 'a' || ch == 'n' || ch == 't' || ch == 'i' || ch == 'c') continue;
                wordSet.add(String.valueOf(ch));
            }
            if (wordSet.size() > N) continue;
            if (wordSet.size() == 0) {
                ans += 1;
                continue;
            }
            all.addAll(wordSet);
            wordList.add(wordSet);
        }
        
        if (all.size() <= N) {
            ans += wordList.size();
        } else {
            ans += find(all, wordList, N);
        }
        
        System.out.print(ans);
    }

    public static int find(Set<String> all, List<Set<String>> wordList, int N) {
        int max = 0;
        List<String> allList = new ArrayList<>(all);
        int allSize = allList.size();
        
        if (allSize <= N) {
            for (Set<String> wordSet : wordList) {
                if (all.containsAll(wordSet)) {
                    max += 1;
                }
            }
            return max;
        }

        for (int i = 0; i < (1 << allSize); i++) {
            Set<String> selected = new HashSet<>();
            for (int j = 0; j < allSize; j++) {
                if ((i & (1 << j)) != 0) {
                    selected.add(allList.get(j));
                }
            }
            if (selected.size() == N) {
                int count = 0;
                for (Set<String> wordSet : wordList) {
                    if (selected.containsAll(wordSet)) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
