import java.util.*;

class Solution {
    static Map<Integer, Integer> map;
    static int num;
    public int solution(int N, int number) {
        num = N;
        int answer = 0;
        map = new HashMap<>();
        int idx = 1;
        for (int i = N; i < 11111111 ; i = i*10+N) {
            map.put(i, idx);
            all(map, idx, i);
            
            idx++;
        }
        
        return map.getOrDefault(number ,-1);
    }
    public void all(Map<Integer, Integer> map, int count, int now) {
        if (now <= 0 || count > 8) {
            return;
        }
        int idx = 1;
        all(map, count+2, now+1);
        all(map, count+2, now-1);
        for (int i = num; i < 11111111 ; i = i*10+num) {
            map.put(i, idx);
            all(map, count+idx, now+i);
            all(map, count+idx, now-i);
            all(map, count+idx, now*i);
            all(map, count+idx, now/i);
            idx++;
        }
        if (count <= 8) {
            if (map.getOrDefault(now,9) > count) {
                map.put(now , count);    
            }
        }
    }
    
}