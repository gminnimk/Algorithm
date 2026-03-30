class Solution {
    
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        
        // [문제 분석]
        // A -> B
        // B -> C
        // => A -> C 간접적 연결 성사
        // 결과적으로 A, B, C는 모두 같은 네트워크 상에 존재.
        
        // n: 컴퓨터의 개수
        // computers: 연결에 대한 정보가 담긴 2차원 배열
        // 네트워크의 개수를 return
        
        
        // [제한 사항]
        // 컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.: 완전탐색
        // 각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
        // i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
        // computer[i][i]는 항상 1입니다.
        
        
        // [코드 흐름]
        // 주어진 변수
        // (1). 컴퓨터의 개수
        // (2). 각 컴퓨터의 연결에 대한 정보가 담긴 2차원 배열
        
        visited = new boolean[n];
        int answer = 0;
        
        // 하나의 컴퓨터를 선택하고 해당 컴퓨터 내 연결에 대한 정보를 탐색해야 함.
        for (int i = 0; i < n; i++) {
            // 이떄 해당 컴퓨터에 대한 네트워크는 확정이니 네트워크 개수 1증가
            if (!visited[i]) {
                answer++;
                dfs(i, n, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int i, int n, int[][] computers) {
        visited[i] = true; // i번 컴퓨터 방문 처리
        
        // 1. 자기 자신의 대한 연결 정보 제외
        // 2. 다른 컴퓨터와의 연결 정보가 존재하는가?
        // 3. 해당 컴퓨터에 대해 방문을 안 했는가?
        // 위 조건들이 만족 시 연결 정보 깊이 우선 탐색 (재귀 동작)
        for (int j = 0; j < n; j++) {
            if (i != j && computers[i][j] == 1 && !visited[j]) {
                dfs(j, n, computers);
            }
        }
    }
}