/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 3 <= N, M <= 200
- 1 <= 주어지는 수 <= 1,000

=> 최악의 경우 O(N * M) => 200 * 200 = 40,000
=> O(N^2) 시간 복잡도 허용 & O(N^3) 까지도 가능 / O(N!) & O(2^N)은 시간 초과 리스크 


# [ 문제 ]

- n: 행의 수
- m: 열의 수
- grid: n*m 크기의 격자


- 2가지 종류의 블럭이 존재함.
- 2종류의 블럭을 격자에 벗어나지 않으면서, 격자위에 올린다 => 블럭이 차지하는 칸 안에 적힌 수의 합이 최대

- 즉, 격자(grid)의 모든 칸들을 주어진 2종류의 블럭으로 모든 경우의 수를 대조 비교하여 최댓값 return
- (이떄, 주어진 블럭은 자유롭게 회전하거나 뒤집을 수 있다)


# [ 메모리 멘탈 모델 ]

- 2종류의 블럭을 분할하여 탐색하도록 구축해야 할 것으로 판단.

1. 직사각형 블록
- (1). 가로 블록으로 모든 격자를 탐색하는 경우
- (2). 세로 블록으로 모든 격자를 탐색하는 경우 

2. 'ㄴ' 자 블록
- 'ㄴ' 자를 회전하거나 뒤집으면 사실 2*2 크기에서 1칸을 제외하고 모든 경우의 수를 볼 수 있는데
- 이 경우 회전 또는 뒤집는 로직이 아니라 해당 칸에서 최솟값을 구하여 빼주고 최댓값을 구하면 되지 않을까 싶음 

3. 1번과 2번에서 구한 최댓값에 대하여 최종 비교 및 최댓갑 return
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(t.solution(n, m, grid));
    }

    private int solution(int n, int m, int[][] grid) {

        int maxSum = 0;
        // 1. 직사각형 블록 탐색
    
        // (1). 가로 방향
        // 문제에서 주어진 블록은 1 * 3 크기의 블록인데
        // 행은 고정 한 상태로 열을 이동하여 최댓값 대조 비교
        for (int i = 0; i < n; i++) {
            
            int sum = 0;
            for (int j = 0; j <= m - 3; j++) {
                sum = grid[i][j] + grid[i][j+1] + grid[i][j+2];

                maxSum = Math.max(maxSum, sum); // 최대합 갱신
            }
        }

        // (2). 세로 방향
        // 열은 고정 한 상태로 행을 이동하여 최댓값 대조 비교
        for (int i = 0; i < m; i++) {
            
            int sum = 0;
            for (int j = 0; j <= n - 3; j++) {
                sum = grid[j][i] + grid[j+1][i] + grid[j+2][i];

                maxSum = Math.max(maxSum, sum); // 최대합 갱신
            }
        }

        // 2. 'ㄴ' 자 블록 탐색 
        // - 'ㄴ' 자를 회전하거나 뒤집으면 사실 2*2 크기에서 1칸을 제외하고 모든 경우의 수를 볼 수 있는데
        // - 이 경우 회전 또는 뒤집는 로직이 아니라 해당 칸에서 최솟값을 구하여 빼주고 최댓값을 구하면 되지 않을까 싶음 

        for (int i = 0; i <= n - 2; i++) {
            for (int j = 0; j <= m - 2; j++) {
                // 특정 크기 (ex. 2*2) 구간에서 모든 합을 구하고 각 크기의 원소 중 가장 작은 값을 뺀다
                // 이 작업을 모든 구간에서 반복하여 최댓값을 갱신한다
                // 문제에서는 'ㄴ' 자 이므로 2*2 크기로 감싸는 걸 가정함
                int v1 = grid[i][j];
                int v2 = grid[i][j+1];
                int v3 = grid[i+1][j];
                int v4 = grid[i+1][j+1];
                
                int totalSum = v1 + v2 + v3 + v4;
                int minValue = Math.min(Math.min(v1, v2), Math.min(v3, v4));
                int blockSum = totalSum - minValue; // 이 값이 문제에서 말하는 'ㄴ' 자 합과 동일함

                maxSum = Math.max(maxSum, blockSum);
            }
        }

        return maxSum;
    }
}