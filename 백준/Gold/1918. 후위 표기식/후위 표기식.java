import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(t.solution(str));
        
        sc.close();
    }

    // 우선순위 판별
    public int priority(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0; 
    }

    public String solution(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (Character.isAlphabetic(x)) { 
                answer += x;
            } 
            // 2. 연산자 및 괄호 처리
            else {
                if (x == '(') {
                    stack.push(x);
                } 
                else if (x == ')') {
                    // 스택이 비어있지 않은지 확인 필수!
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        answer += stack.pop();
                    }
                    // 여는 괄호 제거
                    if (!stack.isEmpty()) stack.pop(); 
                } 
                else {
                    // 연산자 우선순위 비교
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(x)) {
                        answer += stack.pop();
                    }
                    stack.push(x);
                }
            }
        }

        // 3. 남은 연산자 모두 출력
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}