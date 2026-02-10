import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // [문제 분석]
        
        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬: ArrayRangeOf, Arrays.sort
        
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            // i, j, k 를 지정했으니
            // (1). 자르고
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);
            
            // (2). 정렬
            Arrays.sort(slicedArray);
            
            // (3). 리턴 할 배열에 추가
            answer[n] = slicedArray[k - 1];
            
        }
        
        return answer;
    }
}