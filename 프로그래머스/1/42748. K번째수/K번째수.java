// ============================================
// [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]
// array의 길이는 1 이상 100 이하입니다.
// array의 각 원소는 1 이상 100 이하입니다.
// commands의 길이는 1 이상 50 이하입니다.
// commands의 각 원소는 길이가 3입니다.

// => O(N^2) 통과 / 주요 알고리즘 (2차원 DP, 2차 반복문, 단순 시뮬레이션)
// ============================================

// ============================================
// [ Step 2: 명사/동사 키워드 추출 ]
// - 명사: 배열(array), i, j 번째 숫자, k번째 수, 2차원 배열(commands)
// - 동사: 자르다(copyOfRange), 정렬하다(Arrays.sort)
// ============================================

// ============================================
// [ Step 3: 자료형 & 엣지케이스 검증 ]
// - 원소 값이 100 이하로 작으므로 int 타입 충분
// - i와 j가 같을때 검증
// ============================================

// [ 문제 ]
// (1). 배열(array)을 i번째부터 j번째까지 자른다
// (2). 이후 배열을 정렬한다
// (3). 정렬한 배열에서 k번째 숫자를 배열에 담는다
// => 이 과정을 commands 길이 만큼 반복후 배열 return


// [ 요약 ]
// 주어진 2차원 배열의 각 원소를 i,j,k 로 지정 후, 또다른 배열 array에서 i부터 j까지 자르고 정렬 후 k번째 수를 배열에 담는 과정을 2차원 배열의 길이만큼 반복 후 배열을 return 하는 문제

// [ 풀이 ]
import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        // 1. i,j,k 선언
        for (int n = 0; n < commands.length; n++) {
            int i = commands[n][0];
            int j = commands[n][1];
            int k = commands[n][2];
            
            // 2. 자르고 정렬한다
            int[] newArray = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(newArray);
            
            // 3. k번째 수를 배열에 담는다
            answer[n] = newArray[k - 1];
        }
        
        return answer;
    }
}