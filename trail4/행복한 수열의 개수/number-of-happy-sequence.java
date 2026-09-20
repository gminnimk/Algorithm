/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 1 <= M <= N <= 100
=> O(N^2) 시간 복잡도 허용 / O(N!), O(2^N), O(N^3)는 초과 리스크

# [ Step 2: ]


# [ 문제 ]

- n: 격자의 크기
- m: 연속해야 하는 원소의 수 
- grid: 2차원 격자 (n * n)

- 행복한 수열: 동일한 원소가 연속하여 m개 이상 나오는 구간이 존재하는 수열
- (1). 각 행을 왼쪽에서 오른쪽으로 읽어 얻어지는 n개의 수열
- (2). 각 열을 위에서 아래로 읽어 얻어지는 n개의 수열
- 총 2n개의 수열 중 '행복한 수열의 개수' return


# [ 메모리 멘탈 모델 ]

1. 격자의 행을 탐색하는 경우 or 열을 탐색하는 경우로 분리하여 탐색을 구성한다.
=> 행은 grid[i][j] 로 구성하여 i를 고정해서 탐색
=> 열은 grid[j][j] 로 구성하여 i를 고정해서 탐색

2. 각 탐색도중 m만큼 반복되는 수가 존재하면 '행복한 수열' 추가(++)
3. 모든 행과 열을 검수 후에 최종 '행복한 수열' 개수 return 
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

    public int solution(int n, int m, int[][] grid) {

        int happyCount = 0;

        // 1. 행을 탐색 하는 경우
        for (int i = 0; i < n; i++) {

            int[] row = new int[n];
            for (int j = 0; j < n; j++) {
                row[j] += grid[i][j];
            }
            // '행복한 수열'인가? => 이를 판별하기 위해서는 m, 검증 할 대상 행 정보 필요
            if (isHappy(row, m)) {
                happyCount++;
            }
        }

        // 2. 열을 탐색 하는 경우
        for (int i = 0; i < n; i++) {
            
            int[] col = new int[n];
            for (int j = 0; j < n; j++) {
                col[j] += grid[j][i];
            }
            if (isHappy(col, m)) {
                happyCount++;
            }
        }

        return happyCount;
    }

    // 행복한 수열인지 판별하는 메서드
    private boolean isHappy(int[] arr, int m) {

        int currentCount = 1;

        // 엣지 케이스 처리 (배열 길이가 1이거나 주어진 m의 개수가 1이면)
        if (arr.length == 1) {
            return 1 >= m;
        }

        // 3. 넘어온 행 or 열이 '행복한 수열' 인가?
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount >= m) {
                return true;
            }
        }

        return false;
    }
}