import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // [문제 분석]
        // 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬, k번째 수는?
        // => 자르고 정렬 Arrays.copyOfRange(배열, i - 1, j), Arrays.sort()
        
        // commands: 배열 array, [i, j, k]를 원소로 가진 2차원 배열
        
        // 연산 적용 후 나온 결과를 배열에 담아 return
        
        
        // [제한 사항]
        // array의 길이는 1 이상 100 이하입니다.
        // array의 각 원소는 1 이상 100 이하입니다.
        // commands의 길이는 1 이상 50 이하입니다.
        // commands의 각 원소는 길이가 3입니다.
        
        
        // [코드 흐름]
        // 코드 전체 시간 복잡도: O(N logN)
        int[] answer = new int[commands.length];
        
        // (1). 주어진 commands 배열을 반복문을 탐색하고 자르고 정렬한다
        // 루프(O(N)) + 정렬(O(N logN)): O(N logN)
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(slicedArray); // O(N logN)
            
            // (2). 배열에 k번째에 있는 수를 담는다
            answer[n] = slicedArray[k - 1];
        }

        return answer;
    }
}