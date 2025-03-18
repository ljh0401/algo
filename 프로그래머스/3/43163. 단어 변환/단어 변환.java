
class Solution {
    static String[] words;
    static String target;
    public int solution(String begin, String target, String[] words) {
        this.words = words;
        this.target = target;
        boolean[] v = new boolean[words.length];
        int answer = find(begin, 0, v);
        if (answer == 51) answer = 0;
        return answer;
    }
    
    public int find(String word, int count, boolean[] v) {
        int min = 51;
        for (int j = 0; j <words.length; j++) {
            int t = 0;
            if (!v[j]) {
                String s = words[j];
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) != word.charAt(i)) t += 1;
                    if (t > 1) break;
                }
                if (t == 1) {
                    if (s.equals(target)) return count+1;
                    v[j] = true;
                    int MIN = find(s, count+1, v);
                    min = Math.min(min, MIN);
                    v[j] = false;
                }   
            }
        }
        return min;
    }
}