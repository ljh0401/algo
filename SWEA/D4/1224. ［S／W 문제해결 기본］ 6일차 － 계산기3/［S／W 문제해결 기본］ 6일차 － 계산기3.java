import java.util.Scanner;
import java.util.Stack;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		// 10번의 test_case가 주어지므로 T = 10 입력
		int T;
		T=10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
            int  N = sc.nextInt();
            
            // 식 입력 받기
            String words = sc.next();
            
            // postfix 저장할 String 생성
            String postfix = "";
            
            // 임시 저장할 stack 생성
            Stack<Character> save  = new Stack<>();
            
            // 모든 식을 살펴보면서
            for (int i = 0; i < N; i++) {
            	char word = words.charAt(i);
            	// 숫자가 나올 경우 바로 postfix에 저장
            	if ('0' <= word && word <= '9') {
                	postfix += word; 
                } 
                    
                // ( 가 나올 경우 일단 저장
                else if (word == '(') {
                	save.push(word);
                } 
                    
                // ) 가 나올 경우 (가 나올 때까지 pop
                else if (word == ')') {
                    char popItem = save.pop();
                    while(popItem != '(') {
                    	postfix += popItem;
                        popItem = save.pop();
                    }
                } 
                
                // + 나 *의 경우
                else {
                    // * 이면
                	if (word == '*') {
                        // 앞에 * 있으면 이것만 출력
                    	while (!save.isEmpty() && save.peek() == '*') {
                        	postfix += save.pop();
                        }
                    }
                    // + 이면
                    else {
                        // 괄호 빼고 모두 출력
                    	while (!save.isEmpty() && save.peek() != '(') {
                        	postfix += save.pop();
                        }
                    }
                    // 현재 값 임시 저장
                    save.push(word);
                }
            }
            while (!save.isEmpty()) {
    			postfix += save.pop();
    		}
            
            Stack<Integer> stack = new Stack<>();
            // 후위 표기 식 계산 위한 loop
            for (int i = 0; i < postfix.length(); i++) {
                char word = postfix.charAt(i);

                if ('0' <= word && word <= '9') {
                    stack.push(word - '0');
                } 
                else {
                    int num2 = stack.pop();
                    int num1 = stack.pop();
                    int result;
                    if (word == '+') {
                        result = num1 + num2;
                    } else {
                        result = num1 * num2;
                    } 
                    stack.push(result);
                }
			}
            
            // 다 더해진 값 ans로 입력
            int ans =  stack.pop();
            
            // 정답 출력
			System.out.println("#"+test_case+" "+ans);
		}
	}
}