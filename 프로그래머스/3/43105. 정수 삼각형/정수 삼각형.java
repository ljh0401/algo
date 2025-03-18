import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int size = triangle.length;
        int[][] tSum = new int[size][];
        tSum[0] = new int[] {triangle[0][0]};
        for (int i = 1; i < size; i++) {
            int tmp = triangle[i].length;
            tSum[i] = new int[tmp];
            for (int j = 0; j < tmp; j++) {
                if (j == 0) {
                    tSum[i][j] = tSum[i-1][j] + triangle[i][j];
                }
                else if (j == tmp -1){
                 tSum[i][j] = tSum[i-1][j-1] + triangle[i][j];   
                }
                else {
                    tSum[i][j] = Math.max(tSum[i-1][j-1], tSum[i-1][j]) + triangle[i][j];
                }
            }
        }
        int max = 0;
        for (int i = 0; i <triangle[size-1].length; i++) {
            max = Math.max(max, tSum[size-1][i]);
        }
        int answer = max;
        return answer;
    }
}