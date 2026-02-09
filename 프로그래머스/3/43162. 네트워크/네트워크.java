class Solution {
    public int solution(int n, int[][] computers) {
        
        // [문제 분석]
        
        // 컴퓨터 A -> B -> C 일 때 A 와 C도 간접적으로 연결되어 정보 교환 가능
        // => 이러한 지문일때는 보통 그래프 문제 (DFS, BFS에서 DFS를 이용해서 풀기)
        
        // n: 컴퓨터의 개수
        // computers: 연결에 대한 정보가 담긴 2차원 배열
        
        // ex)
        // n: 3
        // computers: [[1, 1, 0], [1, 1, 0], [0, 0, 1]]
        // 첫번째 컴퓨터에는 자기 자신과 두번째 컴퓨터에 대한 연결 정보가 존재
        // 두번째 컴퓨터에는 자기 자신과 첫번째 컴퓨터에 대한 연결 정보가 존재
        // => 서로 연결되어 있으니 네트워크는 1
        
        // 세번째 컴퓨터에는 자기 자신만 연결되어 있으니 네트워크 1
        // return 2
        
        // [분석 결과]
        // {1}. n개의 컴퓨터를 먼저 탐색을 시작한다.
        // (이떄 방문기록이 없으면 네트워크 개수를 1 추가한다)
        // {2}. 탐색을 하면서 해당 컴퓨터 방문 기록이 없다면 해당 컴퓨터 방문을 기록한다.
        // {3}. 다른 컴퓨터에 대한 연결 정보가 있으면 해당 컴퓨터로 이동해서 방문을 기록한다.
        // {4}. 연결 정보가 없다면 다시 돌아와서 반복문으로 방문기록이 없는 컴퓨터를 탐색한다.
        
        // {1}
        int answer = 0;
        boolean[] visited = new boolean[n]; // n개의 컴퓨터 방문 기록 일지
        
        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                answer++;
                dfs(i, n, computers, visited);
            }
        }
        
        // 네트워크의 개수를 return
        
        // [제한사항]
        // (1). i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
        // (2). computers[i][i]는 항상 1
    
        return answer;
    }
    
    private void dfs(int i, int n, int[][] computers, boolean[] visited) {
        visited[i] = true; // {2}. 방문 기록 true
        
        // {3}. 탐색한 컴퓨터의 다른 컴퓨터에 대한 정보 확인
        for (int j = 0; j < computers.length; j++) {
            if (computers[i][j] == 1 && visited[j] != true) {
                dfs(j, n, computers, visited);
            }
        }
    }
}