import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // [문제 분석]
        // 각 기능은 진도가 100%일 때 서비스에 반영
        // 각 기능의 개발속도는 모두 다름
        // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고
        // 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포
        // => FIFO, Queue
        
        // progresses: 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
        // speeds: 각 작업의 개발 속도가 적힌 정수 배열
        
        
        // [제한 사항]
        // 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.
        // => 구할 수 있는 식
        // 남은 진도율 = (100 - 진도율)
        // 배포까지 남은 날짜 = (남은 진도율 / 개발 속도) (여기서 소수점이 나올 수 있으므로 남은 진도율과 개발속도 나머지가 0이 아니면 +1 처리)
        
        
        // [코드 흐름]
        Queue<Integer> queue = new LinkedList<>();
        
        // (1). 각 배포마다 몇 개의 기능이 배포되는지 알기 위해서
        // 각 배포 별 남은 진도율과 남은 배포일을 구한다
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];
            int days = remain / speeds[i];
            
            if (remain % speeds[i] != 0) {
                days++;
            }
            
            // 남은 배포일을 큐에 삽입
            queue.add(days);
        }
        
        // (2). 각 배포 별 배포 될 기능을 저장 할 동적 배열 (몇개가 될 지 모르니)
        List<Integer> list = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int deployProcess = queue.poll();
            int count = 1; // 첫번째는 배포 확정이니까
            
            while (!queue.isEmpty() && queue.peek() <= deployProcess) {
                queue.poll();
                count++;
            }

            list.add(count);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}