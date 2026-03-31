class Solution {
    
    int maxCount = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        // [문제 분석]
        // 피로도 시스템이 존재.
        // 일정 피로도를 사용해 던전을 탐험할 수 있음.
        // 던전은 '최소 필요 피로도', '소모 피로도' 가 존재.
        
        // '최대한 많이 탐험'
        
        // k: 유저의 현재 피로도
        // dungeons: '최소 필요 피로도', '소모 피로도'가 담긴 2차원 배열
        
        // => 유저가 탐험할수 있는 최대 던전 수를 return
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        
        // [코드 흐름]
        // 유저가 던전을 탐험하면서 특정 던전에 대한 조건 성립시 다음 던전을 탐험 및 탐험 던전 수 최신화 필요
        
        // 조건 성립이 아닐 시 이전 방문 체크 해제 후 다른 경로로 재귀 호출
        return maxCount;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        // 던전 탐험에 대한 최댓값 최신화
        maxCount = Math.max(maxCount, count);
        
        // 던전 탐험
        for (int i = 0; i < dungeons.length; i++) {
            // 여기서 검증 조건은 해당 던전을 방문 안했는지? 그리고 현재 유저의 피로도가 '최소 필요 피로도' 보다 크거나 같은지를 검증해줘야 함
            // => boolean 배열 (던전 별 방문 기록을 저장 할)
            if (!visited[i] && k >= dungeons[i][0]) {
                // 이후 조건 성립 시 해당 던전에 대한 방문 기록 체크 (중복 방문 방지)
                visited[i] = true;
                
                // 다음 던전 탐색 (재귀 호출 / 던전 횟수 증가)
                dfs(k - dungeons[i][1], dungeons, count + 1);
                
                visited[i] = false;
            }
        }
    }
}