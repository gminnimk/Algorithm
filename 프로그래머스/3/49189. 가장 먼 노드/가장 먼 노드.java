// # [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

// - 노드의 개수 n은 2 이상 20,000 이하입니다.
// - 간선은 양방향이며 총 1개 이상 50,000개 이하의 간선이 있습니다.
// - vertex 배열 각 행 [a, b]는 a번 노드와 b번 노드 사이에 간선이 있다는 의미입니다.
// => O(N + M) = 70,000 이므로 O(N logN) 까지 시간 복잡도 허용.
// => 간선은 양방향 => 인접 리스트(ArrayList)를 사용해야 함.


// # [ 문제 ]

// - n: 노드의 개수
// - vertex: 간선에 대한 정보가 담긴 2차원 배열

// - n개의 노드가 있는 그래프가 존재. (1부터 n까지 존재)
// - 구해야 할 값: 1번 노드에서 가장 멀리 떨어진 노드의 갯수를 구하고자 함.
// ("가장 멀리 떨어진 노드" = 최단경로로 이동했을 때 간선의 개수가 가장 많은 노드)
// => 최단경로는 보통 BFS 탐색 & 방문 배열 (중복 방문 금지)
// => 얼마나 멀리 떨어져 있는지를 실시간으로 확인하는 거리 상태 배열이 필요

// # [ 요약 ]
// - 인접 리스트를 활용하여 탐색의 속도를 O(N)으로 최적화하고 BFS 탐색을 통해 방문 배열 및 거리 배열을 활용한 최댓값의 depth 노드 개수 구하기 문제


// # [ 메모리 멘탈 모델 ]

// - 1. 주어진 간선의 정보를 효율적으로 처리하기 위해 인접 리스트를 선언 및 적재한다.
// - 2. BFS 탐색을 위해 큐 선언 및 1번 노드(간선 정보)를 삽입한다.
// - 3. BFS 탐색 및 상태 배열 최신화 진행.
// -- 인접한 배열에서 방문한 기록이 있는지 확인.
// -- 없으면 방문 도장 찍고 해당 노드의 거리 번호 배열 값 + 1
// -- 이 떄 depth 값에 대한 max 값을 계속 최신화 (Math.max())
// - 4. 탐색이 모두 끝난 후 거리 배열을 순회하여 max depth 값과 일치하는지 순회 및 업데이트
// - 5. 개수 return

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        // 1. 주어진 간선의 정보를 효율적으로 처리하기 위해 인접 리스트를 선언 및 적재.
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            int u = e[0]; // vertex 배열 [0][0]
            int v = e[1]; // vertex 배열 [0][1]
            graph[u].add(v); // 인접 리스트 e[0] 삽입 (입출력 예로 들자면 3번 노드에 6번 간선 정보 삽입)
            graph[v].add(u); // 인전 리스트 e[1] 삽입 (입출력 예로 들자면 6번 노드에 3번 간선 정보 삽입)
        }
        
        // 입출력 예 (간선의 정보를 인접 리스트에 모두 삽입 완료)
        // 1번 노드 배열 정보: [3, 2]
        // 2번 노드 배열 정보: [3, 1, 4, 5]
        // 3번 노드 배열 정보: [6, 4, 2, 1]
        // 4번 노드 배열 정보: [3, 2]
        // 5번 노드 배열 정보: [2]
        // 6번 노드 배열 정보: [3]
        
        // 거리 상태 배열과 방문 배열을 주어진 vertex 크기만큼 선언
        int[] distance = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        
        
        // 2. BFS 탐색을 위해 큐 선언 및 1번 노드(간선 정보)를 삽입한다.
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1); // 1번 노드 삽입 (1번 노드부터 시작해야 하므로)
        visited[1] = true;
        
        // 3. BFS 탐색 및 상태 배열 최신화 진행.
        while (!queue.isEmpty()) {
            int curr = queue.poll(); // 현재 탐색 중인 노드 추출
            
            // 현재 노드와 연결된 이웃 노드들을 인접 리스트에서 꺼내어 순회
            for (int next : graph[curr]) {
                if (!visited[next]) {
                    visited[next] = true;
                    distance[next] = distance[curr] + 1;
                    queue.add(next); // 다음 연결된 이웃 노드 탐색을 위해 큐 삽입
                }
            }
        }
        
        // => 이 작업이 모두 끝나면 필요한 각 노드 별 depth 크기가 배열 형태로 정해짐
        // 그러면 이 배열에서 이제 최대 거리(depth) 값의 크기를 찾아 비교하고 동일한 개수가 여러개만 카운트 해서 반환하면 됨
        
        // 4. 최대 거리 찾기
        int maxDistance = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i]; // 최대 거리 갱신
            }
        }
        
        // 5. 최대 거리를 가진 노드의 수 구하기
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                count++;
            }
        }
        
        return count;
    }
}