import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        // [문제 분석]
        // 배열을 i번째 ~ j번째까지 자르고 정렬 후 k번째에 있는 수?
        // => Arrays.copyOfRange(대상 배열, 시작, 끝);
        
        // commands: [i, j, k]를 원소로 가진 2차원 배열
        // 앞선 연산을 적용 했을 때 나온 결과를 배열에 담아 return
        
        
        // [문제 정리]
        // 주어진 범위(i, j)로 배열을 자르고 정렬하여 K번째 수를 반복적으로 구하는 문제 
        
        
        // [코드 흐름]
        int[] answer = new int[commands.length];
        
        // (1). 반복해서 K번째 수를 구하고 배열에 저장해야 함
        for (int n = 0; n < commands.length; n++) {
            // (2). 각 i,j,k 지정
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
        
            // (3). 자르고 정렬
            int[] slicedArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(slicedArray);
            
            // (4). 배열에 추가
            answer[n] = slicedArray[k - 1];
        }
        
        return answer;
    }
}