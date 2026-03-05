import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>(); // 대기실 (방 번호 보관)
        
        for (int i = 0; i < prices.length; i++) {
            // 지금 가격이 떨어졌는가?, 대기실 맨 앞 사람과 비교
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int index = stack.pop(); // 가격 하락 확정, 대기실 탈출
                answer[index] = i - index;
            }
            
            stack.push(i);
        }
        
        // 끝까지 가격이 안 떨어진 내용 처리
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = (prices.length - 1) - index;
        }
        
        return answer;
    }
}