/*
# [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 1 ≤ jobs의 길이 ≤ 500
=> worstCase는 500^2 (25,000) 이므로 O(N^2) 시간 복잡도 허용 / O(N^3) 까지 허용 가능

- jobs[i]는 i번 작업에 대한 정보이고 [s, l] 형태입니다.
-- s는 작업이 요청되는 시점이며 0 ≤ s ≤ 1,000입니다.
-- l은 작업의 소요시간이며 1 ≤ l ≤ 1,000입니다.


# [ Step 2: 명사/키워드 추출 ]
# [ Step 3: 자료형 & 엣지 케이스 검증 ]


====================================================================
# [ 문제 ]

- jobs: 각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 정수 배열
- 구해야 할 값: '우선순위 디스크 컨트롤러'가 jobs를 처리했을 때 모든 요청 작업의 반환 시간의 평균의 정수부분을 return

- 반환시간: 작업 종료 시각 - 요청 시각


- 우선순위 디스크 컨트롤러:

0. 하드디스크는 한 번에 하나의 작업만 수행 가능.

1. 어떤 작업 요청이 들어왔을 때 작업의 번호, 작업의 요청 시각, 작업의 소요 시간을 저장해 두는 대기 큐가 있습니다. 처음에 이 큐는 비어있습니다.
=> 대기 큐 선언
=> '번호, 요청 시각, 소요 시간'을 객체로 정의


2. 디스크 컨트롤러는 하드디스크가 작업을 하고 있지 않고 대기 큐가 비어있지 않다면 가장 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 이때, 작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위가 높습니다.
=> '가장 우선순위가 높은 작업을 대기 큐에서 꺼낸다' => PQ 활용
=> '작업의 소요시간이 짧은 것, 작업의 요청 시각이 빠른 것, 작업의 번호가 작은 것 순으로 우선순위' => 커스텀 정렬 구축


3. 하드디스크는 작업을 한 번 시작하면 작업을 마칠 때까지 그 작업만 수행합니다.
=> 비선점형 SJF 스케줄링 기법


4. 하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면 하드디스크가 작업을 마치자마자 디스크 컨트롤러는 요청이 들어온 작업을 대기 큐에 저장한 뒤 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다. 또, 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다. 이 과정에서 걸리는 시간은 없다고 가정합니다.


(4-1). 하드디스크가 어떤 작업을 마치는 시점과 다른 작업 요청이 들어오는 시점이 겹친다면 하드디스크가 작업을 마치자마자 디스크 컨트롤러는 요청이 들어온 작업을 대기 큐에 저장한 뒤 우선순위가 높은 작업을 대기 큐에서 꺼내서 하드디스크에 그 작업을 시킵니다.
=> (1). 현재 시점보다 요청 시점이 낮은 작업들에 대해서 반복문 내에 대기 큐에 삽입 처리 필요
=> (2). 이후 큐에 작업이 비어있지 않다면 작업 처리

(4-2). 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작할 수 있습니다. 이 과정에서 걸리는 시간은 없다고 가정합니다.
=> 이벤트 드리븐 시뮬레이션 활용
====================================================================


# [ 메모리 멘탈 모델 ]

1. '번호, 요청 시각, 소요 시간' & 커스텀 정렬을 구현체로 정의
2. 요청 작업을 저장 할 대기 큐(PQ) 선언 및 변환 & 필요 변수 선언
3. 우선순위 디스크 컨트롤러 작업
- 주어진 작업의 개수가 모두 완료될 떄 까지 수행

-- (1). 현재 시점보다 요청 시점이 낮은 작업들에 대해서 반복문 내에 대기 큐에 삽입 처리 필요
-- (2). 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작.
-- (3). 이후 큐에 작업이 비어있지 않다면 작업 처리

4. 모든 요청 작업의 반환 시간의 평균의 정수부분을 return
*/

import java.util.*;

// 1. '번호, 요청 시각, 소요 시간' & 커스텀 정렬을 구현체로 정의
class Job implements Comparable<Job> {
    // private 로 선언하는 이유는 사용범위에 대한 제약 보호
    // final 을 선언하는 이유는 변하지 않는 상수임을 명시하기 위해서 ((?). 근데 굳이 final을 반드시 선언을 해야하는 이유가 있나?)
    private final int id; // 작업 번호
    private final int requestTime; // 작업 요청 시각
    private final int duration; // 작업 소요 시간
    
    public Job(int id, int requestTime, int duration) {
        this.id = id;
        this.requestTime = requestTime;
        this.duration = duration;
    }
    
    // Getter
    public int getRequestTime() {
        return requestTime;
    }
    
    public int getDuration() {
        return duration;
    }
    
    // 커스텀 정렬
    @Override
    public int compareTo(Job o) {
        // 작업의 소요시간이 짧은 것
        if (this.duration != o.duration) {
            return Integer.compare(this.duration, o.duration);
        }
        
        // 작업의 요청 시각이 빠른 것
        if (this.requestTime != o.requestTime) {
            return Integer.compare(this.requestTime, o.requestTime);
        }
        
        // 작업의 번호가 작은 것 순
        return Integer.compare(this.id, o.id);
    }
}

class Solution {
    public int solution(int[][] jobs) {
        // 2. 요청 작업을 저장 할 대기 큐(PQ) 선언 및 변환 & 필요 변수 선언
        int n = jobs.length;
        Job[] jobList = new Job[n];

        // 2차원 배열을 Job 객체 배열로 변환
        for (int i = 0; i < n; i++) {
            jobList[i] = new Job(i, jobs[i][0], jobs[i][1]);
        }
        
        // 사전 커스텀 정렬
        // (?). 이 'getRequestTime'만 명시해도 3가지 정렬 기준이 적용되는 원리가 궁금함
        Arrays.sort(jobList, (a, b) -> Integer.compare(a.getRequestTime(), b.getRequestTime()));
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        // 필요 변수 선언
        int completedCount = 0; // 완료 작업 카운팅 변수
        int currentTime = 0; // 현재 시각 변수
        int jobIdx = 0; // 현재 작업 인덱스 변수
        int totalTurnAround = 0; // 모든 요청 작업의 반환 시간의 평균의 정수부분 변수
        
        // 3. 우선순위 디스크 컨트롤러 작업
        // - 주어진 작업의 개수가 모두 완료될 떄 까지 수행
        while (completedCount < n) {
        
            // -- (1). 현재 시점보다 요청 시점이 낮은 작업들에 대해서 반복문 내에 대기 큐에 삽입 처리 필요
            while (jobIdx < n && jobList[jobIdx].getRequestTime() <= currentTime) {
                pq.offer(jobList[jobIdx]); // 대기 큐에 작업 삽입
                jobIdx++; // 작업 인덱스 업데이트
            }
            
            // -- (2). 하드디스크가 어떤 작업을 마치는 시점에 다른 작업이 들어오지 않더라도 그 작업을 마치자마자 또 다른 작업을 시작. (대기큐에 작업이 없다면, 작업이 있는 시점으로 강제 이동)
            // 이벤트 드리븐 시뮬레이션
            if (pq.isEmpty()) {
                currentTime = jobList[jobIdx].getRequestTime();
            }
            
            // -- (3). 이후 큐에 작업이 비어있지 않다면 작업 처리
            else {
                Job currentJob = pq.poll(); // 대기큐에서 작업을 꺼내고
                // - 반환시간: 작업 종료 시각 - 요청 시각
                // 작업을 처리하면 현재 시각은 작업이 끝난 시간이 됨
                currentTime += currentJob.getDuration();
                totalTurnAround += (currentTime - currentJob.getRequestTime());
                
                completedCount++;
            }
        }
        
        // 4. 모든 요청 작업의 반환 시간의 평균의 정수부분을 return
        return totalTurnAround / n;
    }
}