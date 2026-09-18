/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 1 <= M <= N <= 100
=> O(N^2) 시간 복잡도 허용, O(N!) & O(2^N)은 리스크 존재


# [ 문제 ]

- n: 첫 번째 줄에 격자의 크기
- m: 연속해야 하는 원소의 수

- n * n 크기의 격자 정보가 주어짐
- 행복한 수열: 동일한 원소가 연속하여 m개 이상 나오는 구간이 존재하는 수열

- 각 행을 왼쪽에서 오른쪽으로 읽어 얻어지는 n개의 수열
- 각 열을 위에서 아래로 읽어 얻어지는 n개의 수열
- 총 2n개의 수열 중 행복한 수열의 개수를 세서 return


# [ 메모리 멘탈 모델 ]

- 주어진 n * n 크기의 격자를 각 행,열을 수열의 형태로 나눈다.
- 각 행과 열의 한 줄을 개별의 수열로 탐색을 진행하고 m개의 연속된 수가 나타나는지 검증을한다
- 검증을 진행하면서 실시간으로 수열의 개수를 업데이트한다.
- 검증이 모두 끝나면 개수를 return 한다

정리해서

1. 각 행과 열을 기준점으로 잡아서 분할하여 탐색하도록 설정한다.
2. 탐색 과정에서 해당 행과 열이 '행복한 수열(m개의 연속된 수가 존재)' 하는지 판별한다.
- true 라면 수열 값 증가
- false 라면 그대로 유지
3. 모든 탐색을 끝내고 최종 수열의 수를 return 한다.

=> 분할 정복 + 이중 for 문을 활용한 완전탐색 (+ Math.max 함수 활용)
*/

import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        
        
        System.out.println(t.solution(n, m, grid));
    }

    private int solution(int n, int m, int[][] grid) {

        int maxCount = 0;

        // 1. 각 행과 열을 기준점으로 잡아서 분할하여 탐색하도록 설정한다.

        // 1-1. 행 기준 수열 탐색
        for (int i = 0; i < n; i++) {
            int[] row = new int[n];

            for (int j = 0; j < n; j++) {
                row[j] = grid[i][j]; // 각 개별 행 기준 수열 선언
            }

            // 행 기준 수열이 만들어졌으므로 '행복한 수열' 인지 판별
            // 이때 '열 기준 수열 탐색' 도 해야하므로 공통 판별 메서드로 분리해서 판별하여 모듈성을 확보하기
            if (isHappy(m, row)) {
                maxCount++;
            }
        }

        // 1-2. 열 기준 수열 탐색
        for (int i = 0; i < n; i++) {
            int[] col = new int[n];
            
            for (int j = 0; j < n; j++) {
                col[j] = grid[j][i]; // 열을 기준으로 수열 선언 
            }

            // 해당 열 '행복한 수열' 검증
            if (isHappy(m, col)) {
                maxCount++;
            }
        }

        return maxCount;
    }

    // 행복한 수열을 검증하기 위해서 받아야 할 매개변수가 무엇이 있을까?
    // 연속된 원소가 m개 인지?
    // 해당 수열의 정보 = int[] row
    private boolean isHappy(int m, int[] row) {
        int currCount = 1; // 현재 진행 중인 연속 길이

        if (row.length == 1) {
            return 1 >= m;
        }

        // 넘겨 받은 수열을 탐색 및 검증
        for (int i = 1; i < row.length; i++) {
            // 연속되는가?
            if (row[i] == row[i - 1]) {
                currCount++;
            } else {
                currCount = 1;
            }

            if (currCount >= m) {
                return true;
            }
        }

        return false;
    }
}