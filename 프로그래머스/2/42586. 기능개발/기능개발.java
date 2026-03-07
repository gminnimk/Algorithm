import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // [문제 분석]
        // 코드 전체 시간 복잡도: O(N)
        
        // 각 기능은 진도가 100%%일 때 서비스에 반영할 수 있음.
        // 각 기능은 개발 속도가 다 다르며 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포 됨.
        // => FIFO, Queue
        Queue<Integer> queue = new LinkedList<>();
        
        // 1. 남은 진도율 탐색 및 큐에 남은 배포일 이관
        // => FIFO 구조에 남은 배포일을 이관해야 각 배포일 개발 속도 비례 하여 이후 값들과 비교하여 배포일에 따라 같이 꺼낼지 말지 구할 수 있음
        for (int i = 0; i < progresses.length; i++) {
            
            // 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 
            // Ex) 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
            // [구할 수 있는 식]
            // (1). 남은 진도율 = 100 - progresses[i];
            int remain = 100 - progresses[i];
            
            // (2). 남은 배포일 = 남은 진도율 / speeds[i]; // 소수점은 어떻게 처리? 올림 처리 해야함
            int days = remain / speeds[i];
            
            // (3). 소수점 처리 = if (남은 진도율 % speeds[i] != 0) { 남은 배포일++ }
            if (remain % speeds[i] != 0) {
                days++;
            }
            
            queue.offer(days);
            // Ex) queue = [7, 3, 9]
        }
        
        // 각 배포 별 몇개의 기능이 같이 배포될 지 모르니 동적 배열 필요
        List<Integer> answer = new ArrayList<>();
        
        // 2. 남은 배포일들이 들어있는 큐가 비어있을 때 까지 반복
        while (!queue.isEmpty()) {
            
            // 3. 맨 앞 값을 꺼내면서 기능이 배포 됨을 추가
            int currentDeploy = queue.poll();
            int count = 1; // 배포 됨
            
            // 4. 이후 배포일들의 배포 여부를 확인
            // 위 기존 예시에서 각 속도 비례 [7, 3, 9] 였으니 7배포 될 때 3이 같이 꺼내져야 함
            while (!queue.isEmpty() && queue.peek() <= currentDeploy) {
                queue.poll();
                count++;
            }
            
            answer.add(count);
        }
    
        // 각 배포마다 몇 개의 기능이 배포되는지 return
        // 메서드 반환 타입이 int 형이므로 동적 배열을 int 배열 형태로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
}