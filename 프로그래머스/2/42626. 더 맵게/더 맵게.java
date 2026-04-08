import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        
        // [문제 분석]
        
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해
        // 스코빌 지수가 가장 낮은 두 개의 음식을 아래와 같은 방법으로 섞어서 새로운 음식 제작
        // => "섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)"
        
        // scoville: Leo가 가진 음식의 스코빌 지수를 담은 배열
        // K: 원하는 스코빌 지수
        // 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수 return
        
        // 그리고 제한 사항에서 "scoville 길이 2 ~ 1,000,000": 이 크기는 일반 정렬 X
        
        
        // [문제 정리]
        
        // 최소 힙을 이용하여 스코빌이 가장 낮은 두 개의 음식을 섞어 이 과정을 반복해 모든 음식의 스코빌 지수가 K 이상일 때를 충족하기 위해 섞어야 하는 "최소 횟수" 를 구하는 문제
        
        // 핵심 키워드: PriorityQueue<Integer>, 공식
        
        
        // [코드 흐름]
        int answer = 0;
        // (1). 최소 힙을 구축하기 위한 우선순위 큐를 선언하고 해당 큐에 스코빌 배열을 모두 이관
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        // (2). "모든 음식의 스코빌 지수가 K 이상" 일 때 까지 반복문 안에서 섞는 횟수 카운팅 작업 시작
        while (pq.peek() < K) {
            
            // [예외] 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 
            // 이 경우는 스코빌 배열에서 2개 이상 없을때 해당하는 조건
            if (pq.size() < 2) {
                return -1;
            }
                
            // (3). 주어진 공식을 이용해서 섞고 pq에 최신화 작업
            int first = pq.poll();
            int second = pq.poll();
            
            int mixed = first + (second * 2); // 공식
            pq.offer(mixed); // pq 최신화
            answer++; // 섞은 횟수 증가
        }
        
        return answer;
    }
}