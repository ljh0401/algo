import java.util.*;

class Solution {
    static int[] dC = new int[] {0, 0, 1, -1};
    static int[] dR = new int[] {1, -1, 0, 0};
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        for (int test = 1; test <= T; test++) {
            int tNum = sc.nextInt();
            char[][] map = new char[16][16];
            sc.nextLine();
            for (int i = 0; i < 16; i++) {
                String st = sc.nextLine();
                for (int j = 0; j < 16; j++) {
                    map[i][j] = st.charAt(j);
                }
            }
            int dep = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[] {1, 1});
            A:
            while(!queue.isEmpty()) {
            	int[] tmp = queue.poll();
                map[tmp[0]][tmp[1]] = '1';
                for (int i = 0; i < 4; i++) {
                	int c = tmp[0] + dC[i];
                    int r = tmp[1] + dR[i];
                    if (c >= 0 && r >= 0 && c < 16 && r < 16) {
                    	if (map[c][r] == '0') {
                        	queue.add(new int[] {c, r});
                        }
                        else if (map[c][r] == '3') {
                        	dep = 1;
                            break A;
                        }
                    }
                }
            }
            
            System.out.println("#"+tNum+" "+ dep);
        }
	}
}