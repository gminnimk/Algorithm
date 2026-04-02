import java.util.*;

class Solution {
    
    // 중복 방지 (2차원 배열)
    boolean[][] visited;
    
    // 합쳐있는 무인도 검증을 위한 방향 배열
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    int n, m;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];
        List<Integer> answer = new ArrayList<>();
        
        // (1). 전체 지도 조사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 숫자가 있고(바다가 아니고) 방문한 적 없다면 새로운 섬 발견
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    answer.add(dfs(i, j, maps));
                }
            }
        }
        
        // (3). 예외 처리 및 정렬
        if (answer.isEmpty()) return new int[]{-1};
        
        Collections.sort(answer);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int dfs(int r, int c, String[] maps) {
        // 방문 도장 찍기
        visited[r][c] = true;
        // 현재 칸의 식량 (char를 int로 변환)
        int sum = maps[r].charAt(c) - '0';
        
        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            
            // 맵 범위 안이고, 바다가 아니며, 아직 방문 안 했다면?
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                if (maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    // 연결된 땅의 식량을 계속 더해가기
                    sum += dfs(nr, nc, maps);
                }
            }
        }
        return sum;
    }
}