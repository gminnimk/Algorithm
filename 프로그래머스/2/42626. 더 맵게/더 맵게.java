import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 1. 우선순위 큐 선언
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 2. 모든 스코빌 지수를 큐에 삽입
        for (int s : scoville ) {
            pq.offer(s);
        }
        
        // 3. 가장 안 매운 음식이 K보다 작을 동안 반복
        // 단, 음식이 2개 이상은 있어야 섞을 수 있음
        while (pq.peek() < K) {
            
            // 섞을 음식이 1개뿐인데 아직 K 미만이라면? 제조 불가
            if (pq.size() < 2) {
                return -1;
            }
            
            // 가장 작은 두 개 꺼내기
            int first = pq.poll();
            int second = pq.poll();
            
            // 섞기
            int mixed = first + (second * 2);
            
            // 다시 넣기
            pq.offer(mixed);
            answer++;
        }
        
        return answer;
    }
}