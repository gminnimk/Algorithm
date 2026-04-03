class Solution {
    
    boolean[] visited; // 직원의 방문 수첩
    int[][] matrix; // 지도(인접 배열)
    int answer = 100;
    
    public int solution(int n, int[][] wires) {
    
        // [문제 분석]
        // n개의 송전탑이 전선을 통해 하나의 '트리'형태로 연결.
        // 이 전선들 중 하나를 끊어서 전력망 네트워크를 2개로 분할.
        // 이때, 두 전력망이 갖게 되는 송전탑의 개수를 최대한 비슷하게 맞춰야 함.
        // '최대한' => DFS, 사장 - 직원 모델
        
        // n: 송전탑의 개수
        // wires: 전선 정보, [v1, v2] => v1, v2 송전탑이 연결
        
        // 전선들 중 하나를 끊고 두 전력망의 송전탑 개수 차이(빼기)가 최솟값이 나오도록 절대값 return
        // '절대값' => Math.abs
        
        
        // [문제 파악 정리]
        // 송전탑과 전선정보가 주어졌고 전선정보를 하나 끊었을때 두 전략망 송전탑 개수의 차를 구하는 문제.
        // 최대한 비슷하게 맞춰야 하며 인접한 송전탑을 찾아야 하므로
        // => DFS, 인접 배열, 방문 배열
        // 백트래킹이 필요하나? 필요없지 않나?
        
        // 핵심 키워드:
        // DFS, 인접 배열, 방문 배열, 절대값(Math.abs), 
        
        
        // [코드 흐름]
        
        // 인접 배열 초기화 (지도 그리기)
        matrix = new int[n + 1][n + 1];
        for (int[] wire : wires) {
            matrix[wire[0]][wire[1]] = 1;
            matrix[wire[1]][wire[0]] = 1; 
        }
    
        // (1). 사장 모델은 주어진 전선 정보를 보고 임의로 하나를 끊고 직원을 보내서 전력망 조사를 한다
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 연결 정보 끊기
            matrix[v1][v2] = 0; 
            matrix[v2][v1] = 0; 
            
            // (2) 조사: '1번 송전탑이랑 연결된 송전탑 조사하기'
            visited = new boolean[n + 1];
            int count = dfs(1, n); // 한쪽 덩어리의 송전탑 개수 카운트
            
            // (3) 두 전력망 차이의 최솟값 갱신
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
            
            // 조사하고 돌아와 연결 정보 복구 (백트래킹)
            matrix[v1][v2] = 1; 
            matrix[v2][v1] = 1;
        }
    
        return answer;
    }
    
    // 직원
    public int dfs(int current, int n) {
        // 송전탑이 아니라 전선 정보에 대한 방문 기록을 남겨야 하지 않나?
        visited[current] = true;
        int count = 1;
        
        for (int next = 1; next <= n; next++) {
            // 인접 배열이 1이고 방문 기록이 없음
            if (matrix[current][next] == 1 && !visited[next]) {
                count += dfs(next, n);
            }
        }
        
        return count;
    }
}