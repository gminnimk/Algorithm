import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        // array: 배열
        // commands: array, [i, j, k]를 원소로 가진 2차원 배열
        
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