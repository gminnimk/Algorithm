import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        // [문제 분석]
        // arr: 숫자 0부터 9까지 이루어진 배열
        // 이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거
        // 제거 후 남은 수 반환할 때 배열 arr의 원소들의 순서를 유지해야 함
        
        // => Stack(LIFO) 또는 Queue(FIFO) 를 활용해서 연속적인 내용들은 제거해나가면 되지 않을까?
        // 입출력 에시를 봤을때는 LIFO가 제일 적합하다고 판단
        
        // 배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return
        
        
        // [제한 사항]
        // 배열 arr의 크기 : 1,000,000 이하의 자연수
        // => O(N^2) 미만의 시간복잡도로 해결
        
        // 배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수
        
        
        // [코드 흐름]
        // 전체 코드 시간 복잡도: O(N)
        
        // (1). LIFO 구조 Stack 선언 및 기존 배열 이관
        Stack<Integer> stack = new Stack<>();
        // 루프(O(N)) * 스택(O(1)): O(N)
        for (int num : arr) {
            if (stack.isEmpty() || stack.peek() != num) {
                stack.push(num);
            }
        }
        
        // (2). 스택에 담긴 결과를 배열로 변환
        int[] answer = new int[stack.size()];
        // 루프(O(N)) * 스택(O(1)): O(N)
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop(); // 뒤에서부터 채워야 순서가 유지됨
        }
        
        return answer;
    }
}