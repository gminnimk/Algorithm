import java.util.*;

class Solution {
    
    // 캐릭터가 움직일 때는 "동, 서, 남, 북" 방향으로 한 칸씩 이동하며
    // => 방향 배열
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    boolean[][] visited; // 중복 방지 배열
    
    public int solution(int[][] maps) {
        
        // [문제 분석] 15:40
        
        // 각 팀은 상대 팀 진영에 "최대한 빨리 도착"하는 것이 유리.
        // => BFS, 수색대 모델
        
        // "게임 맵을 벗아난 길은 갈 수 없음"
        // => 예외 처리
        
        // maps: 게임 맵의 상태 (0(벽), 1(길) 로만 이루어져 있음)
        // 캐릭터 초기 위치: (1, 1) => (0, 0)
        // 상대방 캐릭터 위치: (n, m) => (n - 1, m - 1)
        
        // 캐릭터가 상대 팀 진영에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값 return
        // 단, 상대 팀 진영에 도착할 수 없을 때는 -1 return
        
        
        // [코드 흐름]
        // (1). 구해야 하는 값이 '지나가야 하는 칸의 개수 최솟값'
        // 수색대는 그렇다면 본인의 위치와 현재 몇칸을 다녔는가? 에 대한 정보를 들고다녀야 함
        // => int[]
        // 그리고 수색대의 초기값 위치를 지정해주고 길에 서있으므로 지나간 칸 1을 적립
        int n = maps.length; // 지도의 행 길이
        int m = maps[0].length; // 지도의 열 길이
        visited = new boolean[n][m];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        // (2). 수색대의 본격적인 맵 탐색
        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            // 상대팀 진영에 도착했을떄
            if (r == n - 1 && c == m - 1) { 
                return dist;
            }
            
            // 수색대는 현재 위치에서 동서남북으로 길을 찾아야함
            // 길이 있는 곳들은 모두 개인 지도(queue)에 표시를 한다
            for (int i = 0; i < 4; i++) {
                int nr = dr[i] + r; // 현재 위치에서 방향 행
                int nc = dc[i] + c;
                
                // 맵 바깥을 넘어가면 안 됨
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    // 동, 서, 남, 북 방향 조사를 했는데 길이 존재
                    // 방문한 길이 아니여야 함
                    if (maps[nr][nc] != 0 && !visited[nr][nc]) {
                        // 위 조건을 모두 만족한다? => 수색대는 본인의 지도에 길 위치 값과 각 거리들을 기록
                        visited[nr][nc] = true; // 중복 방문 방지
                        queue.offer(new int[]{nr, nc, dist + 1});
                        // for 문을 다 돌면서 위 작업을 완료하면 다시 while 문으로 돌아가서 조건을 만족하는 맵을 모두 탐색할때 까지 이 과정을 반복한다.
                    }
                }
            }
        }
        
        // 수색대가 모든 길을 다 탐색했는데 상대방을 못 찾았다면
        return -1;
    }
}