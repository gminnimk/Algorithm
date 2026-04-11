import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // [문제 분석]
        // 배열 array를 i ~ j번째 숫자까지 자르고 정렬했을 때,
        // k번째에 있는 수?
        
        // commands: [i, j, k]를 원소로 가진 2차원 배열
        // commands의 모든 원소에 대해 앞선 연산을 적용했을 때 나온 결과를 배열에 담아 return
        
        
        // [문제 정리]
        // 주어진 범위(i ~ j)로 배열을 자르고 정렬하여 k번째 값을 구하여 배열에 담아 반환하는 문제
        
        
        // [코드 흐름]
        int[] answer = new int[commands.length];
        
        // (1). commands의 모든 원소를 수행해야 하니까 반복문
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            // (2). commands 배열의 각 원소를 지정하였으니 이 값을 이용해 
            // array를 자르고 정렬하기
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(slicedArray);
            
            answer[n] = slicedArray[k - 1];
        }
        
        return answer;
    }
}