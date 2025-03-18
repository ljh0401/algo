import java.util.*;

class Solution {
    static int[] dC = {0, 1};
    static int[] dR = {1, 0};
    public int solution(int m, int n, int[][] puddles) {
        int map[][] = new int[n][m];
        map[0][0] = 1;
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[y-1][x-1] = -1;
        }
        for (int i = 1; i < n; i++) {
            if(map[i][0] == -1) {
                break;
            }
            map[i][0] += map[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            if(map[0][i] == -1) {
                break;
            }
            map[0][i] += map[0][i-1];
        }
        int idx = 1;
        while(idx < n) {
            for (int i = 1; i < m; i++) {
                if (map[idx-1][i] > 0 && map[idx][i] != -1) {
                    map[idx][i] += map[idx-1][i];
                }
                if (map[idx][i-1] > 0 && map[idx][i] != -1) {
                    map[idx][i] += map[idx][i-1];
                }
                map[idx][i]%=1000000007;
            }
            idx++;
        }
        
        int answer = map[n-1][m-1];
        return answer;
    }
}