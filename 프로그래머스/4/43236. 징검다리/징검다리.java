import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(rocks);
        int tmp = 0;
        for (int i = 0; i < rocks.length; i++){
            list.add(rocks[i]-tmp);
            tmp = rocks[i];
        }
        list.add(distance - tmp);
        int left = 0;
        int right = distance;
        if (n == rocks.length) return distance;
        while(left < right) {
            int mid = (left+right)/2;
            int sum = 0;
            int doll = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i);
                if (sum < mid) {
                    doll++;
                }
                else {
                    sum = 0;
                }
                
                if (doll > n) break;
            }
            
            if (doll < n) {
                left = mid+1;
            }
            else if (doll > n) {
                right = mid;
            }
            else {
                left = mid+1;
            }
        }
        int answer = left-1;
        return answer;
    }
}
