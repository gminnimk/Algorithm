/*
====================================================
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 1 ≤ jobs의 길이 ≤ 500
=> 프로그램 계산 시간 O(N^2) worstCase는 250,000, O(N^2) 시간복잡도 허용임을 확인.

# [ Step 2: 명사/동사 키워드 추출 ]
# [ Step 3: 자료형 & 엣지케이스 검증 ]
====================================================


====================================================================
# [ 문제 ]

- { jobs }: 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 정수 배열
- { 구해야 할 값 }: '우선순위 디스크 컨트롤러'가 이 작업(jobs)을 처리했을 때 모든 요청 작업의 반환 시간의 평균의 정수부분을 return

- { 반환 시간 }: 작업 요청부터 종료까지 걸린 시간. (작업 종료 시각 - 요청 시각)


- 디스크는 한 번에 하나의 작업만 수행가능.

- { 우선순위 디스크 컨트롤러 }:

- 1. 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
=> 대기 큐 선언 (번호, 요청 시각, 소요 시간) 묶어서


- 2. 디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
- (1-1). 작업을 하고 있지 않으며
=> 작업을 하고 있지 않다는 건 하드디스크가 놀고 있다는 의미 / 즉, 대기 큐가 비어있으니 하드디스크가 작업을 하지 않고 있는 상태

- (1-2). 대기 큐가 비어있지 않다면
=> if (!pq.isEmpty())


- (2). 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 작업 진행 
=> PQ 힙을 사용해야 함을 유추 가능

- (3). 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
=> 커스텀 정렬 사용해야 함을 유추 가능 (힙은 최소힙으로)


- 3. 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
=> 비선점형 SJF (그리디 기반)


- 4. 하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면 하드디스크가 작업을 마치자마자 디스크 컨트롤러는 요청이 들어온 작업을 대기 큐에 저장한 뒤 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 또, 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다. 이 과정에서 걸리는 시간은 없다고 가정합니다.
=> 이벤트 드리븐 시뮬레이션 유추 가능


- { 각 작업에 대한 반환 시간 }: 작업 요청부터 종료까지 걸린 시간. (종료 시간 - 요청 시간)
====================================================================


====================================================================
# [ 메모리 멘탈 모델 ]

1. (번호, 요청 시각, 소요 시간) 객치 및 커스텀 정렬 구현체 관리 & jobs 작업을 Job 객체화
2. 필요 변수 선언 및 효율성을 위해서 요청 시각 기준 선 정렬 처리
3. 우선순위 디스크 컨트롤러 동작
- (1). 디스크 컨트롤러는 모든 요청을 처리해야하므로 모든 작업을 완수할 때까지 반복
- (2). 본격적인 작업을 시키기전에 현재 시점으로부터 작업의 요청 시각이 현재 시점 이하인 작업들에 대해서 대기 큐에 해당 작업들을 이관한다.
- (3). 대기큐가 비어있지 않은 상황 (!pq.isEmpty()) => 가장 우선순위 높은 작업을 꺼내서 작업 처리
- (4). 대기 큐에서 작업을 꺼내고 반환 시간 업뎃

4. 모든 요청 작업의 반환 시간의 평균의 정수부분을 return

====================================================================
*/

import java.util.*;

class Solution {
    
    // 1. 커스텀 정렬 구현체 객체 클래스 생성 (번호, 요청 시각, 소요 시간)
    static class Job implements Comparable<Job> {
        public final int id; // 번호
        public final int requestTime; // 요청 시각 
        public final int duration; // 소요 시간
        
        public Job(int id, int requestTime, int duration) {
            this.id = id;
            this.requestTime = requestTime;
            this.duration = duration;
        }

        // 커스텀 정렬
        @Override
        public int compareTo(Job o) {
            // 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것
            if (this.duration != o.duration) {
                return Integer.compare(this.duration, o.duration);
            }
            else if (this.requestTime != o.requestTime) {
                return Integer.compare(this.requestTime, o.requestTime);                   
            } 
            else {
                return Integer.compare(this.id, o.id);
            }
        }
    }
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Job[] jobList = new Job[n];
        
        // 주어진 jobs 객체화
        for (int i = 0; i < n; i++) {
            jobList[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        
        Arrays.sort(jobList, (a, b) -> Integer.compare(a.requestTime, b.requestTime));
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int completedCount = 0; // 완료한 작업의 수
        int currentTime = 0; // 현재 시각
        int jobIdx = 0; // 작업의 인덱스 표기
        int totalTurnAround = 0; // 반환 시간
        
        
        // 3. 우선순위 디스크 컨트롤러 동작
        // - (1). 디스크 컨트롤러는 모든 요청을 처리해야하므로 모든 작업을 완수할 때까지 반복
        while (completedCount < n) {
            
            // - (2). 본격적인 작업을 시키기전에 현재 시점으로부터 작업의 요청 시각이 현재 시점 이하인 작업들에 대해서 대기 큐에 해당 작업들을 이관한다.
            while (jobIdx < n && jobList[jobIdx].requestTime <= currentTime) {
                pq.offer(jobList[jobIdx]);
                jobIdx++;
            }
            
            // - (3). 하드디스크가 작업을 하고 있지 않는 상황 (PQ가 비어 있는 상황)
            // => 이벤트 드리븐 시뮬레이션 (다음 작업으로 시간 강제 워프)
            // => 예를 들어서 (2) 에서 첫 작업 요청의 시각이 2초이고 현재 시각이 0초이면 while 문은 동작하지 않게 되고 (3) if문으로 넘어오면서 현재 시각을 들어온 요청 시각으로 강제 설정
            if (pq.isEmpty()) {
                currentTime = jobList[jobIdx].requestTime;
            }
            
            // 대기큐가 비어있지 않다면 (!pq.isEmpty())
            // => 작업 진행
            // - (4). 대기 큐에서 작업을 꺼내고 반환 시간 업뎃
            else {
                Job currentJob = pq.poll();
                // 여기서 말하는 '반환 시간'은 '작업의 종료 시각 - 요청 시각'
                // '종료 시각'은 현재까지의 시각 + 작업의 소요 시각
                int currentRequest = currentJob.requestTime;
                currentTime += currentJob.duration;

                totalTurnAround += (currentTime - currentRequest);
                
                // 완료 작업의 수 최신화
                completedCount++;
            }
        }
        
        return totalTurnAround / n;
    }
}