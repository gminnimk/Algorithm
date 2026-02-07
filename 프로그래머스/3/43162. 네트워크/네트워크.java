class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        // [문제 분석]
        
        // (1). A -> B -> C 일때 A -> C 도 간접적으로 연결 가능
        // n: 컴퓨터의 개수
        // computers: 연결에 대한 정보가 담긴 2차원 배열
        // ex) [[1, 1, 0], [1, 1, 0], [0, 0, 1]]: return 2
        
        // 연결을 확인하면서 탐색하는 과정: dfs
        
        // 어떻게 확인을 할건데? 
        // (1). n개의 컴퓨터를 탐색을 한다.
        // (2). 탐색과 동시에 네트워크의 개수를 추가 및 갱신하고 해당 컴퓨터의 네트워크를 깊이 우선 탐색을 한다
        // (3). 해당 컴퓨터의 연결 정보가 들어있는 네트워크 정보를 탐색하면서 다른 컴퓨터의 네트워크가 확인이 된다면 dfs를 재귀 호출하고 아니면 각 컴퓨터의 탐색(반복문)으로 돌아온다.
        // (4). 이 과정을 컴퓨터의 개수가 끝날 때 까지 반복한다.
        
        boolean[] visited = new boolean[n]; // 해당 컴퓨터를 확인했는지 체크하기 위함
        
        for (int i = 0; i < n; i++) {
            // 탐색 시작 (단, 방문 기록이 없다면)
            if (visited[i] != true) {
                answer++; // 네트워크 추가
                dfs(i, n, computers, visited);
            }
        }
        
        // 네트워크의 개수를 return
       return answer;
    }
    
    private void dfs(int current, int n, int[][] computers, boolean[] visited) {
        visited[current] = true; // 해당 컴퓨터는 방문을 했음
        
        for (int next = 0; next < computers.length; next++) {
            // 해당 컴퓨터 연결정보 내에 다른 컴퓨터 연결에 대한 정보가 있으면?
            // 재귀를 호출해서 방문 true 로 변경
            
            // [제한사항]
            // (0). [i][j] 가 동일한 값이면 무조건 1이므로 제외
            // (1). i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현
        
            if (next != current && computers[current][next] == 1 && !visited[next]) {
                dfs(next, n, computers, visited);
            }
        }
        
    }
}