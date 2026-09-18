/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 3 <= N <= 20 
- 격자의 각 칸에 들어있는 값은 0 또는 1
=> O(N^2) 시간 복잡도 허용, O(N!), O(2^N) 도 가능


# [ 문제 ]

- N: 격자의 크기를 나타냄

- N*N 크기의 격자 정보가 주어짐. (동전이 있다면 1, 없다면 0)
- 격자를 벗어나지 않도록 => 맵 범위 벗어나지 않게 처리
- 연속한 3*3 격자를 잡아서 해당 범위 안에 들어있는 동전의 개수를 최대로 retur


# [ 메모리 멘탈 모델 ]

1. 먼저 맵에 좌측 상단에 꼭짓점을 잡는다
2. 그 꼭짓점을 기준으로 3개의 행과 3개의 열들을 모두 탐색한다
3. 탐색하는 과정에서 격자 범위에 들어있는 동전 수를 기존 동전 수 와 대조 비교 및 갱신한다 
*/


import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Main main = new Main(); 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.solution(n, grid));
    }

    private int solution(int n, int[][] grid) {
        int maxCoins = 0;
        
        // 1. 기준점 잡기 (좌측 상단 점)
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= n - 3; j++) {
                int coins = 0;

                // 2. 기준점 기준으로 3 * 3 연속 탐색
                for (int r = i; r < i + 3; r++) {
                    for (int c = j; c < j + 3; c++) {
                        if (grid[r][c] == 1) {
                            coins += grid[r][c];
                        }
                    }
                }

                maxCoins = Math.max(maxCoins, coins);
            }
        }

        return maxCoins;
    }
}