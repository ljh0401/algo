import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine(); 
        String bomb = br.readLine();
        
        StringBuilder stack = new StringBuilder();
        int bombLength = bomb.length();
        
        for (int i = 0; i < word.length(); i++) {
            stack.append(word.charAt(i)); 
            
            if (stack.length() >= bombLength &&
                stack.substring(stack.length() - bombLength).equals(bomb)) {
                stack.setLength(stack.length() - bombLength); // 폭발 문자열 제거
            }
        }
        
        if (stack.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(stack.toString());
        }
    }
}