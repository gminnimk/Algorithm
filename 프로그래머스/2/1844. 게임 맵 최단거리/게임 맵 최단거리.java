import java.util.*;

class Solution {
    
    // 방향 배열
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // [문제 분석]
        // '상대 팀 진영에 최대한 빨리 도착': BFS
        
        // 나의 캐릭터 (행: 1, 열: 1): 초기 값 (0, 0)
        // 상대 캐릭터 (행: n, 열: m): (n - 1, m - 1)
        
        // 캐릭터가 움직일 떄 동, 서, 남, 북 방향으로 한 칸씩 이동 가능: 이동 배열 선언
        // 게임 맵을 벗어난 길은 갈 수 없음: 예외 처리
        
        // maps: 게입 맵의 상태 (0은 벽, 1은 길)
        // 상대 팀 진영에 도착하기 위해 지나야 하는 칸의 개수 최솟값 return
        // 단, 상대 팀 진영에 도착할 수 없을 때는 -1 return
        
        
        // [코드 흐름]
        // 구하고자 하는 값이
        // '현재 캐릭터 위치에서 상대 팀 진영까지의 최솟값'
        // BFS로 현재 캐릭터 위치 기준으로 동서남북을 탐색하여 길이 있는 위치들을 모두 큐에 넣으면서 현재 캐릭터 위치를 최신화 해주고 위치를 이동하면서 거리를 저장 할 값이 필요
        
        // 정리해서
        // (1). 캐릭터의 위치 값
        // (2). 거리를 카운트 할 변수
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // (행, 열, 거리)
        maps[0][0] = 0; // 벽 처리 (중복 방문 방지)
        
        int n = maps.length;
        int m = maps[0].length;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int dist = curr[2];
            
            // 탐색 종료문 (상대 팀 진영 도달 시)
            if (r == n - 1 && c == m - 1) {
                return dist;
            }
            
            // 현재 캐릭터 위치에서 동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // 현재 위치에서 길이 존재하고 맵 밖이 아니라면?
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    // 해당 위치와 거리 최신화
                    queue.offer(new int[]{nr, nc, dist + 1});
                    // 해당 위치 벽 처리
                    maps[nr][nc] = 0;
                    
                }
            }
        }
        
        return -1;
    }
}