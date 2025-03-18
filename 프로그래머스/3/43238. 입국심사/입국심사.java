import java.util.*;
class Solution {
    static int n;
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        this.n = n;
        long answer = 0;
        long left = 0;
        long right = (long)times[0] * n;
        while (left <= right) {
            long time = (left+right)/2;
            
            if (find(times, time)) {
                right = time - 1;
            }
            else {
                left = time + 1;
            }
        } 
        while (find(times, left)) {
            left-=1;
        }
        answer = left+1;
        return answer;
    }
    public boolean find (int[] times, long time) {
        int sum = 0;
        for (int i : times) {
            sum += time/ i;
            if (sum >= n) return true;
        }
        return false;
    } 
}