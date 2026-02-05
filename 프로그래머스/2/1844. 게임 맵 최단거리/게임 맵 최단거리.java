import java.util.*;

class Solution {
    
    // (2). 동,서,남,북 방향으로 한 칸씩 이동: 상하좌우 값
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        // [문제 분석]
        // (1). 최대한 빨리 도착: BFS
        // int[] 로 반환타입을 한 이유는 캐릭터의 위치 정보를 최적으로 파악하기 위해서
        int n = maps.length; // 행의 길이
        int m = maps[0].length; // 열의 길이
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0}); // 시작점 지정
    
        
        bfs(maps, queue, n, m);
        
        int answer = maps[n - 1][m - 1];
        
        return (answer == 1) ? -1 : answer;
    }
    
    private void bfs(int[][] maps, Queue<int[]> queue, int n, int m) {
        
        // 캐릭터의 첫 위치가 지정되었으니 상대 팀 진영 탐색 시작
        while (!queue.isEmpty()) { // queue 배열 즉, 캐릭터가 갈 수 있는 위치의 탐색 정보가 없을 때 까지
            int[] current = queue.poll(); // 현재 위치를 꺼내고
            int r = current[0];
            int c = current[1];
            
            // 현재 위치에서 주위 탐색 및 bfs
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i]; // 현재 위치에서 계산
                int nc = c + dc[i];
                
                        
                // (2-1). 게임 맵을 벗어난 길은 갈 수 없음: 예외 조건 처리
                // (2-2). 0은 벽이 있는 자리, 1은 벽이 없는 자리
                if (nr < 0 || nr >= n || nc < 0 || nc >= m || maps[nr][nc] != 1) {
                    continue;
                }
                
            // 반복문 돌고 기존 위치에서 + 1을 해줌으로써 탐색 과정을 최신화
            maps[nr][nc] = maps[r][c] + 1;
            queue.add(new int[]{nr, nc});
            }     
        }
    }
}