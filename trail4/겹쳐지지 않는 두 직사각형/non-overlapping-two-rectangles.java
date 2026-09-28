/*
# [ Step 1 : 제한사항 확인 및 역분석 => 알고리즘 압축 ]
- 2 <= N, <= M <= 5
=> 2차원 격자를 모두 탐색하는 worst case = 25가지

이차원 영역(grid) 안에 '서로 겹치지 않는 두 직사각형'을 잡아서,
두 직사각형 안에 적힌 정수 값들의 총합을 최대로 return

(1). 직사각형의 가로,세로 & 가로, 세로 크기로 도출될 수 있는 직사각형의 경우의 수 worst case => (6*5/2) * (6*5/2) => 225
(2). 두 직사각형의 경우의 수 225 * 225 
(3). 프로그램에서 연산해야 할 총 경우의 수 (225 * 225) * 25 는 O(N^2) 시간복잡도 허용
 

=> O(N^2) 시간복잡도 허용

# [ Step 2 : 명사/동사 키워드 추출 ]

# [ Step 3 : 자료형 & 엣지케이스 검증 ]
- 격자 안에 값은 '음수'도 허용



# [ 문제 ]

- n: 열의 크기
- m: 행의 크기
- grid: n * m 의 2차원 격자


- 구해야 할 값:
이차원 영역(grid) 안에 '서로 겹치지 않는 두 직사각형'을 잡아서,
두 직사각형 안에 적힌 정수 값들의 총합을 최대로 return

이떄, 각 직사각형의 변들은 격자 판에 평행해야 하며 
2개의 직사각형을 골라야만 함.



# [ 메모리 멘탈 모델 ]

1. 영역 안 '서로 겹치지 않는 두 직사각형'을 만들기 위해 중첩 루프문 구축
- 첫 번째 직사각형, 두 번째 직사각형
- (좌상단, 우하단)을 꼭짓점으로 하여금 직사각형을 지정하기 위해서는 직사각형 하나에 4중 루프 필요.
- 두 직사각형이 '겹치는가'를 확인해야 하므로 루프 안에 루프 구조로 구축하여 변수 스코프를 살려야 함.

2. 두 직사각형이 '겹치지 않는가?'를 확인하는 메서드 구성
3. 해당 메서드를 통과하면 '두 직사각형 안에 적힌 정수 값들의 총합'을 구하는 메서드 구성
4. 중첩 루프문 내에서 최대값 갱신 및 return
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
        // return 할 최대값을 예제를 참고하여 '음수' 표기도 가능하도록 설정
        // 0으로 설정하게 되면 두 직사각형의 합을 구하는 메서드가 최대값으로 음수값을 반환해도 의도하지 않은 0이 결과값을 반환되는 이슈가 발생하게 됨
        int maxSum = Integer.MIN_VALUE;

        // 1. 영역 안 '서로 겹치지 않는 두 직사각형'을 만들기 위해 중첩 루프문 구축
        // 1-1. 첫 번째 직사각형
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = c1; c2 < m; c2++) {
                        
                        // 1-2. 두 번째 직사각형
                        for (int r3 = 0; r3 < n; r3++) {
                            for (int c3 = 0; c3 < m; c3++) {
                                for (int r4 = r3; r4 < n; r4++) {
                                    for (int c4 = c3; c4 < m; c4++) {

                                        // 2. 두 직사각형이 '겹치지 않는가?'를 확인하는 메서드 구성
                                        if (!isOverlapped(n, m, grid, r1, c1, r2, c2, r3, c3, r4, c4)) {
                                            // 3. '두 직사각형 안에 적힌 정수 값들의 총합'을 구하는 메서드 구성
                                            int sum1 = getRectSum(grid, r1, c1, r2, c2);
                                            int sum2 = getRectSum(grid, r3, c3, r4, c4);
                                            
                                            // 4. 중첩 루프문 내에서 최대값 갱신
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

    // 2. 두 직사각형이 '겹치지 않는가?'를 확인하는 메서드 구성
    private boolean isOverlapped(int n, int m, int[][] grid, int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {
        boolean[][] visited = new boolean[n][m];

        // 2-1. 첫 번째 직사각형의 칸들을 방문 처리
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                visited[i][j] = true;
            }
        }

        // 2-2. 두 번째 직사각형과 '방문 처리 배열' 대조 비교를 통한 '겹침 여부' 검증
        for (int i = r3; i <= r4; i++) {
            for (int j = c3; j <= c4; j++) {
                if (visited[i][j] == true) {
                    return true; // 부정 연산자로 !true 반환 (즉, 두 직사각형이 겹쳐서 실패했다는 의미)
                }
            }
        }

        // 2-3. 겹침 여부 통과 시 호출 메서드에서 부정 연산자를 사용했으므로 통과 조건은 !false
        return false;
    }

    // 3. 해당 메서드를 통과하면 '두 직사각형 안에 적힌 정수 값들의 총합'을 구하는 메서드 구성
    private int getRectSum(int[][] grid, int r1, int c1, int r2, int c2) {
        int sum = 0; // Integer.MIN_VALUE 로 설정하지 않은 이유는 두 직사각형의 합을 온전히 구하는것에 목적이기에

        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += grid[i][j];
            }
        }

        return sum;
    }
}