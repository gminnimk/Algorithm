import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        // 1. 오름차순 정렬 (0, 1, 3, 5, 6)
        Arrays.sort(citations);
    
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            
            // 2. h 후보군 계산
            // 현재 논문을 포함하여 자기보다 인용 횟수가 많은 논문의 개수
            int h = n - i;
            
            // 3. 현재 논문의 인용 횟수가 h 이상인지 확인
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}