/*

# [ 제한사항 & 알고리즘 ]
- 100 * 100 worstCase는 10,000 이므로 O(N^2) 시간 복잡도 허용 


# [ 자료형 & 엣지케이스 ]
- 상대 팀 진영에 도착할 수 없을때 -1 return



# [ 문제 ]

- { maps }: n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열
- { 구해야 할 값 }: 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값 return (상대 팀 진영에 도착할 수 없을때 -1 return)


- 해당 게임에서 각 팀은 '상대 팀 진영에 최대한 빨리 도착하는 것'이 유리
- 나의 캐릭터 초기 위치는 (행: 1, 열: 1) / 상대 팀 진영 (행: 5, 열: 5)

- 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동
=> 방향 배열이 필요함을 유추할 수 있음. 
(x,y 좌표가 프로그램 세계에서는 수학적으로 다르게 동작하는 걸로 인지하고 있음)
예를 들어서 x 좌표는 동일한데 y 좌표는 반대로 동작하는것으로 이해하고 있음.
dx = {-1, 1, 0, 0};
dy = {0, 0, 1, -1}; 이런식으로 해야 프로그램에서는 의도된대로 동작할 것으로 예상

- 게임 맵을 벗어난 길은 갈 수 없음
=> 조건문 범위 예외 처리



# [ 메모리 멘탈 모델 ]

1. 방향 배열 & 실시간으로 현재 위치 및 거리를 담을 큐 선언 및 세팅
2. 게임 맵 탐색 시작
- (1). 탐색은 큐가 empty() 일 때 까지 탐색 범위 설정
- (2). 탐색 도중 상대 팀 진영에 도달하면 dist값 바로 return
- (3). 현재 위치에서 동서남북 배열 확인 및 벽이 없는 자리 확인 및 갱신

3. 최솟값 return / 상대 팀 진영에 도착할 수 없으면 -1 return
*/

import java.util.*;

class Solution {
    
    // 방향 배열
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // 초기 정보 세팅 (현재 나의 캐릭터 위치 및 실시간 거리) / (행, 열, 거리)
        
        int n = maps.length; // 행의 길이
        int m = maps[0].length; // 열의 길이
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        
        // 탐색 시작
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            // - (2). 탐색 도중 상대 팀 진영에 도달하면 dist값 바로 return
            if (r == (n - 1) && c == (m - 1)) {
                return dist;
            }
            
            // 현재 위치 기준 동, 서, 남, 북 탐색
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + r;
                int ny = dy[i] + c;
                
                // 게임 맵을 벗어나지 않으면서 
                if (nx < n && nx >= 0 && ny < m && ny >= 0) {
                    // 현재 위치 기준 주변에 벽이 없는가?
                    if (maps[nx][ny] == 1 && !visited[nx][ny ]) {
                        // True => 갱신
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        

        return -1;
    }
}