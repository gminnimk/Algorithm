class Solution {
    
    int maxCount = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        
        // [문제 분석] 13:27
        // 피로도 시스템 존재 (피로도를 이용해 던전 탐색 가능)
        
        // 던전 탐험을 위해 필요한
        // '최소 필요 피로도'
        // '소모 피로도'
        
        // k: 유저의 현재 피로도
        // dungeons: '최소 필요 피로도', '소모 피로도'가 담긴 2차원 배열
        
        // 유저가 탐험할수 있는 최대 던전 수 return
        
        
        // [코드 흐름]
        // 결국 구해야 하는 건 '유저가 탐험할 수 있는 최대의 던전 수'
        // DFS 가 더 적합하지 않을까
        // 왜? => 하나의 던전을 탐험했다고 가정, 만약에 이후의 던전을 계속 탐험하고자 하는데
        // 소모도가 부족함 => 이럴 경우에 백트래킹 개념이 필요한데
        // 백트래킹 개념에 특화된 방식이 바로 DFS

        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        
        return maxCount;
    }
    
    public void dfs(int k, int[][] dungeons, int count) {
        maxCount = Math.max(maxCount, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            
            // 조건에 충족하면 maxCount 증가
            // (1). 해당 던전에 방문 기록이 없어야 함
            // (2). 현재 피로도가 최소 필요도 보다 크거나 같을 것
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false; // 다른 경로를 위해 
            }
        }
    }
}