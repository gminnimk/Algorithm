import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        
        // LIFO, Stack 자료구조 활용
        Stack<Character> stack = new Stack<>();
        
        // 입력된 값 순회
        for (char x : s.toCharArray()) {
            // '(' 일 경우 stack에 push (왼쪽 => 오른쪽)
            if (x == '(') {
                stack.push(x);
            } else {
                // ')' 가 입력된 경우
                
                // stack이 비어있다면 ('(' 와 짝을 못 맞추니 "NO" 처리)
                if (stack.isEmpty()) {
                    return false;
                }
                
                // if 문 검증 이후
                // () 짝을 맞춰서 pop 가능
                stack.pop();
            }
        }
        
        // 모든 순회를 마치고 stack에 문자가 남아있다면
        if (!stack.isEmpty()) {
            return false;
        }

        return answer;
    }
}