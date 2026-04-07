import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // [문제 분석]
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들고자 함.
        // 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같이 특별한 방법으로 섞어 새로운 음식을 만듦 
        
        // "섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)"
        // "스코빌 지수 가장 낮은 두 개의 음식" => 우선순위큐를 활용하여 빠르게 최소값 찾아주기
        
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞음
        
        // scoville: 가진 음식의 스코빌 지수를 담은 배열
        // K: 원하는 스코빌 지수
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수 return
        
        
        // [문제 정리]
        // 우선순위큐를 활용하여 가장 낮은 스코빌 2개를 차례대로 가져와 주어진 공식을 이용해 모든 음식의 스코빌 지수가 K 이상이 충족될 때 섞은 횟수를 구하는 문제
        
        
        // [코드 흐름]
        int answer = 0;
        
        // (1). 주어진 스코빌은 모두 우선순위큐에 담는다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        // (2). 무한 반복문안에서 조건식을 세워서 섞은 횟수를 구한다
        // 언제까지? 모든 음식의 스코빌 지수가 K 이상일 때 까지
        while (pq.peek() < K) {
            
            // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우 -1 return
            if (pq.size() < 2) { return -1; }
            
            int first = pq.poll();
            int second = pq.poll();
            
            // 스코빌 지수 계산
            int mixed = first + (second * 2);
            pq.offer(mixed);
            answer++;
        }
        
        return answer;
    }
}