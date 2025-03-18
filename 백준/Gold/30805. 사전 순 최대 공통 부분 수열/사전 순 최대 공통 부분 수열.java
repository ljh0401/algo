import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int num1, num2;
	static Map<Integer, PriorityQueue<Integer>> map1, map2;
	static List<Integer> list;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int[] nums = new int[N];
    	map1 = new HashMap<>();
    	for (int i = 0; i < N; i++) {
    		nums[i] = Integer.parseInt(st.nextToken());
    		if (map1.containsKey(nums[i])) {
    			map1.get(nums[i]).add(i);
    		}
    		else {
    			map1.put(nums[i], new PriorityQueue<>());
    			map1.get(nums[i]).add(i);
    		}	
    	}
    	int M = Integer.parseInt(br.readLine());
    	st = new StringTokenizer(br.readLine());
    	int[] NUMS = new int[M];
    	map2 = new HashMap<>();
    	for (int i = 0; i < M; i++) {
    		NUMS[i] = Integer.parseInt(st.nextToken());
    		if (map2.containsKey(NUMS[i])) {
    			map2.get(NUMS[i]).add(i);
    		}
    		else {
    			map2.put(NUMS[i], new PriorityQueue<>());
    			map2.get(NUMS[i]).add(i);
    		}
    	}
    	list= new ArrayList<>();
    	boolean can = true;
    	A:
    	while(can) {
    		int tmp = num1;
    		for (int i = 100; i >= 1; i--) {
    			if (map1.containsKey(i) && map2.containsKey(i)) {
    				list.add(i);
    				num1 = map1.get(i).peek()+1;
    				num2 = map2.get(i).peek()+1;
    				break;
    			}
    			if (i == 1) {
    				can = false;
    				break A;
    			}
    		}
    		map1 = new HashMap<>();
    		map2 = new HashMap<>();
    		for (int i = num1; i < N; i++) {
    			if (map1.containsKey(nums[i])) {
        			map1.get(nums[i]).add(i);
        		}
        		else {
        			map1.put(nums[i], new PriorityQueue<>());
        			map1.get(nums[i]).add(i);
        		}
    		}
    		for (int i = num2; i < M; i++) {
    			if (map2.containsKey(NUMS[i])) {
        			map2.get(NUMS[i]).add(i);
        		}
        		else {
        			map2.put(NUMS[i], new PriorityQueue<>());
        			map2.get(NUMS[i]).add(i);
        		}
    		}
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(list.size()+"\n");
    	for (int num : list) {
    		sb.append(num+" ");
    	}
    	System.out.print(sb);
    }
}