import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        // 지문 분석
        
        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬
        // => int[] temp = Arrays.copyOfRange(자를 배열, 어디부터, 어디까지);
        
                
        // k번째에 있는 수를 구한다
        // => 자른 정렬에서
        
        // commands: 배열 array, [i, j, k]를 원소로 가진 2차원 배열
        // 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int[] temp = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(temp);
            
            answer[n] = temp[k - 1];
        }
        
        return answer;
    }
}