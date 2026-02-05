class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // [문제 분석]
        
        // (1). 컴퓨터 A -> B -> C 가 연결되어 있는데 A와 C 또한 연결이 가능하다
        // n: 컴퓨터의 개수
        // computers: 연결에 대한 정보가 있는 2차원 배열
        // 여기서 각 컴퓨터가 연결되어 있지 않다면 네트워크의 개수를 각각으로 계산
        
        // 그렇다면 각 컴퓨터가 연결되어 있는지에 대한 체크가 필요: visited 배일 및 boolean 타입
        boolean[] visited = new boolean[n];
        
        // 모든 컴퓨터를 검사
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, n, computers, visited); 
            }
        }
        
        return answer;
    }
    
    private void dfs(int i, int n, int[][] computers, boolean[] visited) {
        visited[i] = true;
        
        // 주변 네트워크 연결 유무 확인
        for (int j = 0; j < n; j++) {
            if (computers[i][j] == 1 && !visited[j]) {
                dfs(j, n, computers, visited);
            }
        }
    }
}