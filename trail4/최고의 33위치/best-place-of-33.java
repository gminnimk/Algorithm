/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 3 <= N <= 20
=> O(N^2) 시간 복잡도 허용

- 격자의 각 칸에 들어있는 값은 0 또는 1입니다.


# [ Step 2: 명사/동사 키워드 추출 ]

- 명사: 격자의 크기(n), 2차원 격자(grid), 동전의 여부(0 or 1)
- 동사: Math.max(), 반복문, 검증문


# [ Step 3: 자료형 & 엣지케이스 검증 ]

- int 형 통과

- 엣지 케이스 검증
- (1). 3 * 3 격자는 grid 범위를 벗어나면 안 됨.
=> 행과 열을 좌측 상단에 고정한 상태에서 해당 범위를 모두 탐색하도록 범위를 설정


# [ 문제 ]

- n: 격자의 크기
- grid: 격자의 정보 (0 or 1)
=> 1(동전 O) / 0(동전 X)

- n * n 격자를 벗어나지 않도록
- 연속한 3개 행, 3개의 열이 이루는 3 * 3 크기의 부분 격자를 grid 안에 들어있는 동전의 개수를 최대로 return


# [ 메모리 멘탈 모델 ]

1. 고정된 3 * 3 크기로 주어진 n * n 크기를 모두 탐색해야 하므로

1. 탐색 할 시점의 기준점을 잡는다 (좌측 상단 꼭짓점)
2. 기준점을 잡은 상태에서 3 * 3 크기의 모든 격자를 탐색한다 (grid 범위 벗어나지 않게)
3. 탐색을 하면서 해당 범위의 동전 개수를 갱신하고 위의 작업을 모든 grid 범위에서 탐색이 끝날떄까지 반복한다
4. 최대값을 갱신한다
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(t.solution(n, grid));
    }

    public int solution(int n, int[][] grid) {

        int maxCoins = 0;

        // 1. 좌측 상단 꼭짓점 잡기 (gird size를 고려하여 범위를 고려)
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {

                int currentCoins = 0;

                // 2. 꼭짓점을 기준으로 잡았으니 꼭짓점을 기준으로 행과 열을 탐색
                for (int r = i; r < i + 3; r++ ) {
                    for (int c = j; c < j + 3; c++) {
                        // 3. 동전 개수 확인
                        if (grid[r][c] == 1) {
                            currentCoins += grid[r][c];
                        }
                    }
                }

                maxCoins = Math.max(maxCoins, currentCoins);
            }
        }

        // 4
        return maxCoins;
    }
}