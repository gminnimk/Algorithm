class Solution {
    
    boolean[] visited; // 던전 중복 방문 방지
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        // [문제 분석]
        // 피로도 시스템이 존재 (던전 탐험에 사용)
        // "최소 필요 피로도": 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도
        // "소모 피로도": 던전을 탐험한 후 소모되는 피로도
        
        // 하루에 한 번씩 탐험할 수 있는 던전이 존재하며 유저는 최대한 많이 탐험하고자 함
        // "최대한 많이 탐험" => DFS , 사장-직원 모델
        
        // k: 유저의 현재 피로도
        // dungeons: 각 던전별 "최소 필요 피로도", "소모 피로도"가 담긴 2차원 배열
        // 유저가 텀함할수 있는 최대 던전 수 return
        
        // 문제 1줄 정리:
        // 주어진 던전을 모두 탐색하면서 피로도를 확인하면서 백트래킹 개념을 이용해 최대한 많은 던전을 탐색하는 문제
        
        
        // [코드 흐름]
        // 입출력 예 설명을 보면
        // "첫 번째 -> 두 번째 -> 세번째": 최소 필요 피로도가 부족해 2개의 던전만 탐색
        // "첫 번째 -> 세 번째 -> 두번쨰": 모두 만족하여 3개의 던전 모두 탐색
        // => 여기서 알 수 있는점은 "백트래킹" 개념이 존재
        
        // "최대한 많이"
        // => (1). DFS, 사장은 직원에게 피로도를 주고 던전 탐색을 보낸다
        visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return answer;
    }
    
    // 직원
    public void dfs(int k, int[][] dungeons, int count) {
        
        answer = Math.max(count, answer);

        // (2). 직원은 탐색을 하기전 탐색할 던전의 "최소 필요 피로도" 와 자신의 현재 피로도를 비교 및 던전의 방문기록을 확인한다
        for (int i = 0; i < dungeons.length; i++) {
            if (dungeons[i][0] <= k && !visited[i]) {
                
                visited[i] = true;
                // 다음 던전 탐색전 "현재 피로도 - 소모 피로도"
                dfs(k - dungeons[i][1], dungeons, count + 1);
                
                // dfs 탐색 후 조건이 충족되지 않아 탐색이 안 되면
                visited[i] = false; // (3). 이전 탐색 던전 방문 기록 지우기 (백트래킹)
            }
        }
    }
}