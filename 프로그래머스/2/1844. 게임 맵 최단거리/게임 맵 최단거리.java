import java.util.*;

class Solution {
    
    // 방향 배열 선언
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        
        // [ 5단계 학습 파이프라인 ]
        
        // [1단계] : 제약 사항 분석 및 전략 예측
        // "maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수" , "상대 팀 진영에 최대한 빨리 도착", " 칸의 개수의 최솟값"
        // => n x m 의 최대는 10^4 이면서 최솟값을 요구하므로 BFS 유력
        
        
        // [2단계] : 핵심 명사 & 동사 도출
        // 명사(변수/자료구조): 게임 맵(maps), 방문 기록(visited[][]), 방향 배열(dr[], dc[]), 캐릭터 초기 위치(maps[0][0]), 상대 팀 진영(maps[n - 1][m - 1]), 현재 위치 & 기록(Queue<int[]>, int[]{n, r, dist})
        // 동사(연산/로직): 값 넣기(q.offer()), 값 빼기(q.poll()), 상대팀 진영 도착 시 return  
        
        
        // [3단계] : 지문 의도 해제 및 핵심 기준 수립
        // 지문 의도: 현재 캐릭터 위치에서 상대팀 진영까지 도달하는 거리의 합산 중 가장 작은 거리의 합산 값 추출
        // 핵심 기준: int[]{n, r, dist} 를 이용하여 실시간 dist 계측 및 조건 충족시 즉시 리턴
        
        // [4단계] : 1~2줄 요약 및 알고리즘 파이프라인 확립
        // 요약: 현재 위치에서 BFS 알고리즘을 이용하여 목적지 까지의 최소 거리를 구하는 문제
        // 알고리즘 파이프라인: Queue + int[]{n, r, dist} + visited[][]
        
        
        // [5단계] : 방어 논리 구축 (예외 검증 및 엣지 케이스)
        // (1). 캐릭터가 움직일 때는 동, 서, 남, 북 방향으로 한 칸씩 이동하며, 게임 맵을 벗어난 길은 갈 수 없습니다. (최상단으로 엣지 케이스 설정 필수)
        // (2). 검은색 부분은 벽으로 막혀있어 갈 수 없는 길이며, 흰색 부분은 갈 수 있는 길입니다.
        // (3). 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 
        // => 엣지 케이스 필요 O
        
        // n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
        // => 엣지 케이스 필요 X
        
        
        
        // [ 실제 코드 구현 ]
        
        // 1. 초기 값 세팅
        // maps를 변수로 주었으므로 이를 통해 행과 열의 크기를 설정
        int n = maps.length; // 행 길이
        int m = maps[0].length; // 열 길이
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 1}); // 초기 행, 열, 거리 값
        
        // 방문 배열 세팅
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true; // 초기 위치 방문 기록 설정
        
        // 2. BFS 탐색
        while(!q.isEmpty()){
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];
            int dist = current[2];
            
            // 도착지 만나면 dist return
            if (r == n - 1 && c == m - 1) { return dist; }
            
            // 상, 하, 좌, 우 검증
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                // [가드레일 1] 맵 밖으로 벗어났는가?
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) { continue; }
                // [가드레일 2] 벽이 막혀있으며(maps[nr][nc] == 0), 방문 기록이 있는 곳인가?
                if (maps[nr][nc] == 0 || visited[nr][nc]) { continue; }
                
                // 위 엣지 케이스 통과 후 queue 최신 경로 갱신
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc, dist + 1});
            }
        }
        
        // BFS 탐색 이후 결과가 안 나온다는 건 아래의 상황을 의미
        // 단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return
        return -1;
    }
}