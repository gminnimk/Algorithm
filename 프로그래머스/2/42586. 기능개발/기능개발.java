import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // [문제 분석]
        // 기능 개선 작업을 수행 중이며, 각 기능은 진도가 100%일 때 서비스에 반영이 가능
        // 각 기능의 개발속도는 모두 다르기에 뒤에 있는 기능이 앞에 있는 기능 보다 먼저 개발될 수 있고, 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됨
        // => FIFO, Queue
        
        // progresses: 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
        // speeds: 각 작업의 개발 속도가 적힌 정수 배열
        
        // 각 배포마다 몇 개의 기능이 배포되는지를 return
        // => 각 배포별 몇개의 기능이 배포되는지는 동적이므로 동적 배열 이용
        
        
        // [제한 사항]
        // 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다.
        // 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어짐.
        // => 구할 수 있는식
        // => 남은 진도율 = 100 - progresses[i];
        // => 배포 예상일 = 남은 진도율 / speeds[i];
        // (여기서 남은 진도율 % speeds[i] != 0 이면 ++ 해줘서 올림 처리를 해줘야 함)
        
        
        // [코드 흐름]
        Queue<Integer> queue = new LinkedList<>();
        
        // (1). 각 작업의 진도 탐색 및 남은 진도율과 각 개발 속도에 따른 남은 배포일을 구하고 큐에 저장한다
        // => ex)
        // progresses = [93, 30, 55]
        // speeds = [1, 30, 5]
        // 남은 배포일(queue) = [7, 4, 9] 
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i]; // 남은 진도율
            int days = remain / speeds[i]; // 남은 배포일
            
            // 남은 배포일 올림 처리
            if (remain % speeds[i] != 0) { days++; }
            
            queue.offer(days);
        }
        
        // (2). 각 배포마다 몇 개의 기능이 배포되는지 담을 동적 배열
        List<Integer> answer = new ArrayList<>();
        
        // (3). 앞에 있는 기능이 먼저 배포되어야 뒤에서 끝난 기능도 같이 나갈 수 있음
        while (!queue.isEmpty()) {
            
            // 먼저 맨 앞 남은 배포일에서 poll을 해 맨 앞 값을 꺼내고
            int currentDeploy = queue.poll();
            int count = 1; // 배포 완료 하나 이미 꺼냈으니 카운트 처리
            
            // 그 뒤에 있는 값과 비교하여 작거나 같으면 count를 추가하여 동적 배열에 저장한다
            while (!queue.isEmpty() && queue.peek() <= currentDeploy) {
                queue.poll();
                count++;
            }
            
            answer.add(count);
        }
    
        return answer.stream().mapToInt(i -> i).toArray();
    }
}