import java.util.*;

class Solution {
    boolean solution(String s) {
        
        // [문제 분석]
        // 괄호가 바르게 짝지어졌다:
        // '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻.
        // => LIFO(Stack) 자료구조 이용
 
        // Ex)
        // "()()" 또는 "(())()" 는 올바른 괄호입니다.
        // ")()(" 또는 "(()(" 는 올바르지 않는 괄호입니다.
        
        
        // [제한 사항]
        // 문자열 s의 길이 : 100,000 이하의 자연수
        // => O(N^2) 아래의 시간 복잡도
        
        // 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.
        
        
        // [코드 흐름]
        // (1). Stack 선언 및 문자열 s 를 문자 형태로 순환
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray() ) {
            // (2). c 가 '(' 이면
            if (c == '(') { stack.push('('); }
            
            // (3). c가 ')' 이면
            else {
                // 비어있을때
                if (stack.isEmpty()) {
                    return false;
                }
                
                // '()' 꺼내기
                stack.pop();
            }
        }
        
        // 반복문 전부 순회 하였는데 stack 에 값이 있다면?
        if (!stack.isEmpty()) { return false; }
        
        return true;
    }
}