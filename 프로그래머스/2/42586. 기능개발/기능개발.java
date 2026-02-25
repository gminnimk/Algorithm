import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // [문제 분석]
        // 프로그래머스 팀에서는 기능 개선 작업을 수행 중
        // 각 기능은 진도가 100%일 때 서비스에 반영이 가능
        
        // 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발된다고 해도 앞에 있는 기능이 배포될 때 함께 배포 되어야 함
        // => 기존값(Max) 비교
        
        
        // progresses: 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열
        // => Queue
        
        // speeds: 각 작업의 개발 속도가 적힌 정수 배열
        
        // 각 배포마다 몇 개의 기능이 배포되는지를 return
        
        
        // [제한 사항]
        // 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정.
        
        // ex)
        // 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어짐.
        // => 배포 계산법이 뭘까? 
        // 100% 가 작업 완료 기준
        // 100 - 현재 작업의 진도 / 속도 => 
        // 100 - 95 / 4 =>  5/4(올림(ceil)하여 2)일간 작업 후 배포 가능
        
        // [코드 흐름]
        // 1. Queue 선언
        Queue<Integer> queue = new LinkedList<>(); 
        
        // 2. 각 작업이 며칠 걸리는지 계산하여 큐에 넣음
        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i]; // 남은 작업량
            
            int days = remain / speeds[i];
            if (remain % speeds[i] != 0) { days++; }
            
            queue.add(days);
        }
        
        // 결과를 담을 리스트 (몇 번 배포될지 모름 => 동적 리스트) 
        List<Integer> answerList = new ArrayList<>();
        
        // 3. 큐가 빌 때까지 반복하여 배포 그룹을 생성
        while (!queue.isEmpty()) {
            int deployDay = queue.poll();
            int count = 1;
            
            // 4. 기준보다 빨리 끝난 자식들이 있는지 확인
            while (!queue.isEmpty() && queue.peek() <= deployDay) {
                queue.poll();
                count++;
            }
            
            // 한 그룹의 배포가 끝날 때마다 리스트 개수 저장
            answerList.add(count);
        }
        
        return answerList.stream().mapToInt(i -> i).toArray();
    }
}