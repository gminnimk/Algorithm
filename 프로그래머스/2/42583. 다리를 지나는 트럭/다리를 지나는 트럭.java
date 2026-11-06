/*
# [ 제한사항 및 알고리즘 역분석 ]

- bridge_length는 1 이상 10,000 이하입니다.
- weight는 1 이상 10,000 이하입니다.
- truck_weights의 길이는 1 이상 10,000 이하입니다.
=> 알고리즘 worstCase는 bridge_length * truck_weights
=> O(10^8)이므로 O (N logN)까지가 안전라인
=> 트럭의 순서는 일정하므로 우선순위 힙이나 정렬은 사용 불가능

- 모든 트럭의 무게는 1 이상 weight 이하입니다.



# [ 문제 ]

- { bridge_length }: 다리에 올라갈 수 있는 트럭 수
- { weight }: 다리가 견딜 수 있는 무게
- { truck_weights }: 트럭 별 무게
- { 구해야 할 값 }: 모든 트럭이 다리를 건너려면 최소 몇초가 걸리는지 return

- 트럭 여러 대가 강을 가로지르는 일차선 다리를 정해진 순으로 건너려 함
=> 일차선 다리이므로 단순 반복문에서 시물레이션을 돌리지 않을까 유추



# [ 메모리 멘탈 모델 ]

- 모든 트럭이 다리를 건너려면 최소 몇초가 걸리는지 return

예시 참고 했을때

1. 다리 위 트럭을 관리하는 FIFO 자료구조 & 필요 변수 선언
- Queue (다리 크기 만큼 초기 0 세팅)
-- 0을 초기에 세팅하는 이유로는 
(1). 반복문 내에서 초기 동작에 오류가 없게
(2). 슬라이딩 윈도우 방식 동작

- 경과 시간
- 트럭 인덱스
- 현재 무게


2. 트럭이 다리를 건너는 시물레이션 (모든 트럭이 다리에 승차할 때 까지)

Ex)
while (truckIndex < truck_weights.length) {

-- 경과 시간(time)은 루프 문 안에서 순차 증가 
-- 현재 무게에서 다리 위 트럭을 하차 시키면서 차감 업뎃

-- 현재 무게 + 특정 대기 트럭의 무게를 합산한 값이 지정된 무게 제한 보다 작거나 같은가? 를 검증
if (currentWeight + truck_weights[truckIndex] <= weights) {
-- 조건문 통과 O
=> 다리를 건너는 트럭 (자료구조) 에 해당 트럭 승차
=> 현재 무게 & 트럭 인덱스 업뎃
} 

eles {
-- 조건문 X
=> 다리 위에 해당 트럭 승차 X / 대기
=> FIFO 자료구조에 0을 집어넣음으로써 밀어내기 (그래야 조건 문 밖에 poll() 을 호출함으로써 다리 위 트럭을 하차시킬 수 있으니까)
}

}


3. 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 

트럭이 다리를 건너는데 걸리는 시간(bridge_length) + 마지막 트럭이 다리위에 올라탈 때 까지의 시간(time)

*/

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 다리 위 트럭을 관리하는 FIFO 자료구조 & 필요 변수 선언
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        // 2. 트럭이 다리를 건너는 시물레이션 (모든 트럭이 다리에 승차할 때 까지)
        while (truckIndex < truck_weights.length) {
            time++;
            currentWeight -= bridge.poll(); // 트럭이 하차하면서 무게 업뎃
            
            if (currentWeight + truck_weights[truckIndex] <= weight) {
                // 조건문 통과 O
                bridge.offer(truck_weights[truckIndex]);
                currentWeight += truck_weights[truckIndex];
                truckIndex++;
            }
            
            // 조건문 통과 X
            else {
                bridge.offer(0); // 앞차 하차 유도 & 큐의 크기 유지
            }
        }
        
        return bridge_length + time;
    }
}