/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 2 <= N, M <= 5
=> 격자의 최대 크기 worst case 는 25

- 실제 프로그램이 연산해야 할 내용은
- 두 직사각형의 합이 최대로 되는 모든 경우의 수 이므로
- 두 직사각형을 잡는 경우의 수 (가로 * 세로)^2 = 15^2 => 255
- 두 직사각형을 모두 탐색해야 하므로 255^2
=> O(N^2) 시간복잡도 허용 확인  


# [ Step 3: 자료형 & 엣지케이스 검증 ]

- 예제에서 영역안 값이 음수로도 허용됨을 확인 (Integer.MIN_VALUE)
- 두 직사각형은 겹치면 안 되므로 이를 검증하기 위한 '방문 배열' 활용 필요


# [ 문제 ]

- n: 행의 크기
- m: 열의 크기
- grid: n * m 2차원 격자

- 영역 안 서로 겹치지 않는 두 직사각형을 잡아, 
- 두 직사각형 안에 적힌 정수 값들의 총 합을 최대로 하는 프로그램 작성

- 이떄, 각 직사각형의 변들은 격자 판에 평행 & 꼭 2개의 직사각형을 골라야만 함.


# [ 메모리 멘탈 모델 ]

- 영역안에서 '겹쳐지지 않는 두 직사각형' 을 잡고 두 직사각형 합이 최대로 return

1. '겹쳐지지 않는 두 직사각형'을 구성하기 위해서는
- 하나의 직사각형을 먼저 잡고 이후 직사각형을 이어서 구축하는 것
- 하나의 직사각형은 좌상단 꼭짓점과 우하단 꼭짓점으로 구성
=> 이렇게 중첩 루프로 두개의 직사각형을 구성해야 상호비교가 가능해짐
=> 그렇다면 만약 중첩 루프가 아닌 구성을 하였을때 상호바교가 어떻게 불가능한지에 대한 매커니즘이 궁금해짐

2. 두개의 직사각형을 구축한 후
- 해당 직사각형이 겹치는지를 검증
- 해당 직사각형의 합이 최대인지를 검증 및 갱신
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
    
    public int solution(int n, int m, int[][] grid) {
        int maxSum = Integer.MIN_VALUE;

        // 1. '겹쳐지지 않는 두 직사각형'을 구성

        // 1-1. 첫 번째 직사각형 (좌상단 꼭짓점(r1, c1), 우하단 꼭짓점(r2, c2))
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = c1; c2 < m; c2++) {

                        // 1-2. 두 번째 직사각형 (좌상단 꼭짓점(r3, c3), 우하단 꼭짓점(r4, c4)
                        for (int r3 = 0; r3 < n; r3++) {
                            for (int c3 = 0; c3 < m; c3++) {
                                for (int r4 = r3; r4 < n; r4++) {
                                    for (int c4 = c3; c4 < m; c4++) {

                                        // 두 직사각형이 겹치는가?
                                        if (!isOverlapped(n, m, r1, c1, r2, c2, r3, c3, r4, c4)) {
                                    
                                            // 두 직사각형의 정수 값들의 합이 최대인가?
                                            int sum1 = getRectSum(r1, c1, r2, c2, grid);
                                            int sum2 = getRectSum(r3, c3, r4, c4, grid);
                                            
                                            maxSum = Math.max(maxSum, sum1 + sum2);
                                        }
                                    }   
                                }
                            }   
                        } 
                    }   
                }
            }   
        }

        return maxSum;
    }

    // 두 직사각형이 겹치는지 확인하는 메서드
    private boolean isOverlapped(int n, int m, int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        boolean[][] visited = new boolean[n][m];

        // 첫 번째 직사각형에 대한 크기에 따라 방문 처리
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                visited[i][j] = true;
            }
        }

        // 두 번째 직사각형에 대한 크기에 따라 방문 처리 및 겹치는지 확인
        for (int i = r3; i <= r4; i++) {
            for (int j = c3; j <= c4; j++) {
                if (visited[i][j] == true) {
                    return true;
                }
            }
        }

        return false;
    }

    // 두 직사각형의 정수 값들의 합이 최대인가?
    private int getRectSum(int r1, int c1, int r2, int c2, int[][] grid) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += grid[i][j];
            }
        }
        
        return sum;
    }
}