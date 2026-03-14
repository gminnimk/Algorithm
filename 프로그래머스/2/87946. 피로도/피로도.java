class Solution {
    
    int maxCount = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        // [문제 분석]
        // 피로도 시스템 존재.
        // 일정 피로도를 사용해서 던전을 탐험할 수 있습니다.
        
        // 하루에 한 번씩 탐험할 수 있는 던전이 여러개 존재.
        // 유저는 던전들을 최대한 많이 탐험하고자 함.
        // => DFS/재귀
        dfs(k, 0, dungeons, visited);
        
        // k: 유저의 현재 피로도
        // dungeons: 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열
        
        // 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험: 두번째까지 탐험 가능
        // 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험: 끝까지 탐험 가능
        // => 백트래킹 필요
        
        // 유저가 탐험할 수 있는 최대 던전 수를 return 
        
        return maxCount;
    }
    
    /* 필요한 매개변수
        1. 유저의 현재 피로도
        2. 몇번 탐험 했는지?
        3. 남은 던전의 배열
        4. 방문 기록
    */
    public void dfs(int k, int currentCount, int[][] dungeons, boolean[] visited) {
        
        // 1. 첫 번째 → 두 번째 → 세 번째 던전 순서로 탐험: 모두 탐험 X
        // 2. 첫 번째 → 세 번째 → 두 번째 던전 순서로 탐험: 모두 탐험 O
        // => 백트래킹 개념 필요 (boolean 으로 제어 가능)
        
        // 최대 탐험 수 갱신
        maxCount = Math.max(currentCount, maxCount);
        
        // 던전 탐색
        for (int i = 0; i < dungeons.length; i++) {
            
            // (1). 재귀를 돌기 전에 방문 기록이 없으며, 사용자의 피로도가 던전의 최소 요구 피로도 보다 크거나 같은가?
            if (k >= dungeons[i][0] && !visited[i]) {
                // (2). 탐험 했으니 방문 처리
                visited[i] = true;
                
                dfs(k - dungeons[i][1], currentCount + 1, dungeons, visited);
                
                // 만약 재귀를 돌다가 더이상 돌 곳이 없다면 이전 방문 기록을 지우고
                // 이전 경로로 돌아와서 다른 경로를 탐색하기
                visited[i] = false; 
            }
        }
    }
}