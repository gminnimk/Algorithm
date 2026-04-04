class Solution {
    
    boolean[] visited; // 중복 방문 방지
    int network = 0; // 반환할 네트워크 개수
    
    public int solution(int n, int[][] computers) {
        
        // [문제 분석]
        // A -> B, B -> C : A -> C 도 연결됨을 의미
        // 즉, A, B, C 는 같은 네트워크 상에 존재
        
        // n: 컴퓨터의 개수
        // computers: 연결에 대한 정보가 담긴 2차원 배열
        // 네트워크의 개수를 return
        
        // 문제 1줄 정리:
        // 컴퓨터의 연결 정보를 탐색해서 연결되어 있는 컴퓨터들을 모두 탐색하여 하나의 네트워크로 취급하여 네트워크 개수를 구하는 문제
        // => DFS, 사장-직원 모델
        
        
        // [코드 흐름]
        // (1). 사장은 직원에게 컴퓨터의 개수와 연결 정보 2차원 배열을 주고
        // 네트워크 수를 구하라고 지시
        visited = new boolean[computers.length];
        for (int i = 0; i < n; i++) {
            
            // 직원이 모두 다 찾고 돌아왔는데 for 문에 만약 방문하지 않은 컴퓨터가 있다면
            if (!visited[i]) {
                // 일단 해당 컴퓨터에 대한 연결 정보를 탐색하기로 했으니
                // 네트워크 개수는 증가 보장
                network++;
                
                // 해당 컴퓨터와의 연결 정보 모두 탐색
                dfs(i, n, computers);
            }
        }
        
        return network;
    }
    
    public void dfs(int current, int n, int[][] computers) {
        visited[current] = true;
        // (2). 직원은 하나의 컴퓨터를 탐색하여 이 컴퓨터와 연결된 모든 컴퓨터 탐색
        for (int j = 0; j < n; j++) {
            // 연결에 대한 정보가 있어야 함 (자기 자신은 제외)
            // 컴퓨터 방문 기록은 없어야 함
            if (current == j) { continue; }
            if (computers[current][j] != 0 && !visited[j]) {
                // 해당 연결 정보가 존재하는 컴퓨터로 dfs
                dfs(j, n, computers);
            }
        }
    }
}