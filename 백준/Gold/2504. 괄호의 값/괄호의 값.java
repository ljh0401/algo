import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws IOException {
        // buffer 설정
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // String 리스트에 담기
        List<String> word = new ArrayList<>(Arrays.asList(br.readLine().split("")));
        // int 리스트 nums로 전환호
        List<Integer> nums = new ArrayList<>();
        for (int i = 0; i < word.size(); i++) {
            if (word.get(i).equals("(")) {
                nums.add(-1);
            }
            else if (word.get(i).equals(")")) {
                nums.add(-2);
            }
            else if (word.get(i).equals("[")) {
                nums.add(-3);
            }
            else if (word.get(i).equals("]")) {
                nums.add(-4);
            }
        }
        for (int i = nums.size()-1; i > 0; i--) {
            if (nums.get(i-1) == -1 && nums.get(i) == -2) {
                nums.remove(i);
                nums.set(i-1, 2);
                continue;
            }
            else if (nums.get(i-1) == -3 && nums.get(i) == -4) {
                nums.remove(i);
                nums.set(i-1, 3);
                continue;
            }
        }
        int ans = 0;
        while(true) {
            int size = nums.size();
            for (int i = nums.size()-2; i >= 1; i--) {
                if (nums.get(i-1) == -1 && nums.get(i+1) == -2 && nums.get(i) > 0) {
                    nums.remove(i+1);
                    nums.set(i-1, nums.get(i)*2);
                    nums.remove(i);
                    break;
                }
                else if (nums.get(i-1) == -3 && nums.get(i+1) == -4 && nums.get(i) > 0) {
                    nums.remove(i+1);
                    nums.set(i-1, nums.get(i)*3);
                    nums.remove(i);
                    break;
                }
                else if (nums.get(i) > 0 && nums.get(i+1) > 0) {
                    int sum = nums.get(i)+nums.get(i+1);
                    nums.set(i, sum);
                    nums.remove(i+1);
                    continue;
                }
                else continue;
            }
            if (nums.size() == 2) {
                int SUM = nums.get(0) + nums.get(1);
                nums.remove(1);
                nums.set(0, SUM);
            }
            if (size == nums.size()) {
                if (size != 1 || nums.get(0) < 0) {
                    ans = 0;
                }
                else {
                    ans = nums.get(0);
                }
                break;
            }
        }
        bw.write(""+ans);
        bw.flush();
        bw.close();
    }
}