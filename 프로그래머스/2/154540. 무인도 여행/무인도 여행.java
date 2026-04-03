import java.util.*;

class Solution {
    
    boolean[][] visited;
    int n, m;
    
    // '상, 하, 좌, 우로 연결되는 땅들은 하나의 무인도를 이룸'
    // => 방향 배열 필요
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    // 사장님
    public int[] solution(String[] maps) {
        
        // [문제 분석]
        
        // 지도: 바다('X')와 무인도('1 ~ 9')
        // '1 ~ 9' 는 해당 무인도의 식량 수 = 머물 수 있는 수
        
        // maps: 지도를 나타내는 문자열 배열
        
        // 각 섬에서 최대 며칠씩 머무를 수 있는지 배열에 오름차순으로 담아 return
        // '최대 며칠씩 머무룰 수 있는지' => DFS, 사장 - 직원 모델
        // '오름차순 정렬' => Arrays.sort or Collections.sort 사용
        
        
        // 문제 1 ~ 2줄 정리:
        // 지도를 탐색하여 식량이 존재하는 무인도 (붙어있다면 하나의 무인도로 취급)를 찾아내어 각 무인도 별 최대로 머무룰 수 있는 기간을 구해서 오름차순 배열로 반환하는 문제
        
        // 문제 적용 핵심 개념 키워드:
        // DFS, 사장 - 직원 모델, 방향 배열, 방문 기록(직원의 중복 탐색을 방지해야함)
        // 입력값이 '문자열'이기에 아스키 코드를 활용해 정수 합산값을 최신화하면 되지 않을까
        
        // [코드 흐름]
        
        // (1). 사장은 지도를 보며 무인도를 찾아서 직원을 호출한다
        // 주어진 입력값은 1차원 배열이지만 문자열별 값을 봐야하기에 2중 for 탐색 필요
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m]; // 지도의 방문 기록 검증
        List<Integer> list = new ArrayList<>(); // 무인도가 얼마나 저장될 지 모르니 동적 배열 타입으로 선언
        
        for (int i = 0; i < n; i++) { // 문자열 (행)
            for (int j = 0; j < m; j++) {// 문자열의 문자 (열)
                // 탐색 전 무인도이고 방문기록이 없는지 검증 필요
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    list.add(dfs(i, j, maps)); // 직원 호출 및 배열 저장
                }
            }
        }
        
        // '만약 지낼 수 있는 무인도가 없다면 -1을 배열에 담아 return'
        if (list.isEmpty()) { return new int[]{-1}; };
    
        // (5). 사장은 모든 맵 탐색 후 배열을 오름차순으로 정렬한다
        Collections.sort(list); // ArrayList 이기에 컬렉션 소트 사용
        
        // (6). 해당 정렬된 배열을 int 형으로 변환 후 반환한다.
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // 직원
    public int dfs(int i, int j, String[] maps) {
        
        // (2). 직원은 해당 무인도에 대한 방문 처리 후 상하좌우(인접한) 무인도가 있는지 검증
        visited[i][j] = true;
    
        // (2-1). 무인도의 식량 값 (정수값으로 구하기)
        int sum = maps[i].charAt(j) - '0';
        
        // (3). 해당 무인도를 기점으로 동서남북 탐색 
        for (int k = 0; k < 4; k++) {
            int nr = dr[k] + i;
            int nc = dc[k] + j;
            
            // (3-1). 지도를 벗어나지 않으며
            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                // 인접한 지역이 바다가 아니고 방문 기록이 없으면
                if (maps[nr].charAt(nc) != 'X' && !visited[nr][nc]) {
                    // 하위 직원 호출 
                    sum += dfs(nr, nc, maps);
                }      
            }
        }
        
        // (4). 무인도 탐색이 끝나면 해당 무인도의 식량 값 사장님께 반환
        return sum;
    }
}