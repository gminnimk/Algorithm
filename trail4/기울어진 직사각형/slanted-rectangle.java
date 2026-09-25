/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 3 <= N <= 20
=> N * N 의 Worst Case 는 400, O(N^2) 시간복잡도 혀용

- 1 <= 격자 값 <= 100


# [ 문제 ]

- n: 격자의 크기 (행과, 열)
- grid: 2차원 격자

- 기울어진 직사각형:
- 격자내에 있는 한 지점으로부터 대각선으로 움직이며 반시계 순회를 했을 때 지나왔던 지점들의 집합
- 이 떄 반드시 아래에서 시작해서 1, 2, 3, 4번 방향순으로 순회해야하며 각 방향으로 최소 1번은 움직여야 함.
- 또한, 이동하는 도중 격자 밖으로 넘어가서는 안 됨.

- 구해야 할 값: 가능한 기울어진 직사각형들 중 최대의 합을 출력


# [ 메모리 멘탈 모델 ]

- 격자의 크기를 고려하여 '기울어진 직사각형'의 규칙을 지키면서 직사각형의 '최대의 합'을 구하는게 목표
- '대각선으로 움직이며 반시계 순회' 를 어떻게 로직상으로 구현할 것인가? 가 관건으로 보여지는데 
- 이 부분도 사실 '맨해튼 거리' 와 같이 직관적으로 바라보기 보다 반대로 뒤집어서 쉽게 바라볼 수 있는 방법이 존재하지 않을까


- '한 지점으로부터' => 기준점 잡기
- '대각선으로 움직이며 반시계 순회' => 방향 및 이동 배열
- 방향 배열은 {우상, 좌상, 좌하, 우하} 로 구성이 돠어야 함
- 방향을 잡은 후 대각선 이동의 의도를 충족시키기 위해서 이동 배열로 상태를 관리, 해당 방향으로 얼마만큼 이동해야 하는가?
- 이때 직사각형의 성질을 이용하면 되지 않을까 {w, h, w, h} 와 같이

1. 격자내에 있는 한 지점을 잡는다. (위치)
2. 직사각형의 변 크기만큼 탐색하도록 내부 반복문을 설정하고 반시계 순회를 돈다. (상태)
3. 방향 및 이동 배열을 활용하여 격자 밖 예외처리를 하면서 탐색 및 기록 갱신을 한다.
*/

import java.util.Scanner;
public class Main{
    public static void main(String[] args){
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

    public int solution(int n, int[][] grid){
        int maxSum = 0;

        // 1. 격자내에 있는 한 지점을 잡는다. (위치)
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                
                // 2. 직사각형의 변 크기만큼 탐색하도록 내부 반복문을 설정하고 반시계 순회를 돈다. (상태)
                // 너비와 높이의 크기는 최소 1이여야 하니까
                for (int w = 1; w < n; w++) {
                    for (int h = 1; h < n; h++) {

                        // 반시계 방향 순회를 탐색한다.
                        int sum = getMaxSum(r, c, w, h, n, grid);
                        maxSum = Math.max(maxSum, sum);
                    }
                }
            }
        }
        return maxSum;
    }

    // 3. 방향 및 이동 배열을 활용하여 격자 밖 예외처리를 하면서 탐색 및 기록 갱신을 한다. (헬퍼 메서드)
    private int getMaxSum(int r, int c, int w, int h, int n, int[][] grid){
        // {우상, 좌상, 좌하, 우하}
        int[] dr = {-1, -1, 1, 1};
        int[] dc = {1, -1, -1, 1};

        // 방향을 잡았으니 그 방향만큼 이동 할 이동배열 선언
        int[] moveNum = {w, h, w, h};

        int sum = 0;

        int currR = r;
        int currC = c;

        // 반시계 방향 탐색 및 에외 처리
        for (int d = 0; d < 4; d++) {
            for (int step = 0; step < moveNum[d]; step++) {

                currR += dr[d];
                currC += dc[d];

                // 격자 밖으로 나가면 예외 처리
                if (currR < 0 || currR >= n || currC < 0 || currC >= n) {
                    return 0;
                }

                sum += grid[currR][currC];
            }
        }

        return sum;
    }
}