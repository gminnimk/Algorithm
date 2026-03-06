import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        
        // [문제 분석]
        
        // 운영체제가 다음 규칙에 따라 프로세스를 관리할 경우 특정 프로세스가 몇 번째로 실행되는지?
        
        // (Ex).
        // 프로세스 4개 [A, B, C, D]가 순서대로 실행 대기 큐에 들어있고, 
        // 우선순위가 [2, 1, 3, 2]라면 [C, D, A, B] 순으로 실행하게 됩니다.
        // => location = 2 일때 [2, 1, 3, 2] 에서 2는 3을 가리키고 규칙에 따라 프로세스 관리가 되어 [C, D, A, B]로 되면 기존 2의 위치는 1에 있으므로 1 return
        // => 여기서 필요한 정보는 각 우선순위에 대한 기존 위치 정보가 필요하다는 점을 얻을 수 있음
        
        // priorities: 현재 실행 대기 큐에 있는 프로세스의 중요도가 순서대로 담긴 배열
        // location: 몇 번째로 실행되는지 알고싶은 프로세스의 위치를 알려주는 매개변수
        
        
        // [규칙]
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            
            // 큐에 이관할 때 location과의 규칙 이후 기존과 이전 값 위치 비교를 위한 기존 위치 값 추가
            // {우선순위, 기존 위치}
            queue.offer(new int[]{priorities[i], i});
        }
        
        int answer = 0;
        
        while (!queue.isEmpty()) {
            // 1. 실행 대기 큐(Queue)에서 대기중인 프로세스 하나를 꺼냅니다.
            int[] currentProcess = queue.poll(); // A(2) | [B(1), C(3), D(2)]
            boolean hasHigherPriority = false;
            
            // 2. 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면 방금 꺼낸 프로세스를 다시 큐에 넣습니다.
            for (int[] next : queue) {
                if (next[0] > currentProcess[0]) {
                    hasHigherPriority = true;
                    break;
                }
            }
            
            // 3. 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행합니다.
                //   3.1 한 번 실행한 프로세스는 다시 큐에 넣지 않고 그대로 종료됩니
            if (hasHigherPriority) {
                queue.offer(currentProcess);
            } else {
                answer++;
                
                if (currentProcess[1] == location) {
                    return answer;
                }
            }
        }
        return answer;
    }
}