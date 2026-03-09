class Solution {
    
    int answer = 0;
    boolean visited[];
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        // DFS 시작 (현재 피로도, 던전 정보, 현재까지 탐험한 수)
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    private void dfs(int k, int[][] dungeons, int count) {
        // 현재까지 탐험한 수(count)와 기준 최댓값(answer)을 비교해서 갱신
        answer = Math.max(answer, count);
        
        // 모든 던전을 하나씩 확인하며 탐험 가능한지 체크
        for (int i = 0; i < dungeons.length; i++) {
            
            // 아직 방문하지 않았으며, 현재 피로도(k)가 최소 필요 피로도 이상인가?
            if (!visited[i] && k >= dungeons[i][0]) {
                
                // [방문 도장 찍기]
                visited[i] = true;
                
                // [다음 던전으로 출발]
                dfs(k - dungeons[i][1], dungeons, count + 1);
                
                // [방문 도장 지우기]
                visited[i] = false;
            }
        }
    }
}