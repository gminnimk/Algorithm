import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    private int bfs(int[][] maps) {
        int n = maps.length; // 행의 길이
        int m = maps[0].length; // 열의 길이
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 행, 열, 거리
        maps[0][0] = 0; // 방문 처리
        
        // 코드 구현 흐름
        // 1. 탐색 과정을 저장 할 Queue 배열 생성
        // 2. 캐릭터 초기값 추가 및 해당 부분 0처리
        
        // 큐가 비어있을 때 까지 반복문
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 초기 값 꺼내주고
            int r = current[0]; // 행
            int c = current[1]; // 열
            int dist = current[2]; // 거리
            
            
            // 반복문 종료 조건 (maps[n - 1][m - 1]에 도달 시)
            if (r == n - 1 && c == m - 1) { return dist; }
            
            
            // 초기 값 기준으로 동서남북 비교 및 탐색
            for (int i = 0; i < 4; i++) {
                
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1) {
                    maps[nr][nc] = 0;
                    queue.add(new int[]{nr, nc, dist + 1});
                }
            }
        }
        
        return -1;
    }
}