import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        // [문제 분석]
        // 중앙에는 노란색, 테두리 1줄은 갈색
        // 각 색상 격자의 개수는 알지만, 전체 카펫의 크기는 기억 X
        
        // brown: 카펫의 갈색 격자의 수
        // yellow: 카펫의 노란색 격자의 수
        
        // 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 
        
        // 주어진 조건에서 구할 수 있는 식
        
        // 카펫의 전체 가로를 w, 전체 세로를 h 라고 가정
        // 전체 격자 개수 (w * h): brown + yellow
        
        // 노란색 격자 개수: 노란색 가로(w - 2), 세로(h - 2)
        // => (w - 2) * (h - 2) = yellow
        
        // 갈색 격자 개수: 전체에서 노란색을 뺀 나머지
        // => (w * h) - yellow = brown
        
        // 전체 카펫의 크기: brown + yellow;
        
        
        // 노란색 가로 = 갈색 가로 - 2, 노란색 세로 = 갈색 세로 - 2;
        // 카펫의 가로(w), 세로(h)의 식: (w - 2) + (h - 2): 
        
        
        // [코드 흐름]
        int[] answer = new int[2];
        int totalSize = brown + yellow; // 전체 격자 수
        
        // 세로(h)는 최소 3부터 시작, 가로보다 작거나 같아야 하므로 sqrt(totalSize)
        for (int h = 3; h <= Math.sqrt(totalSize); h++) {
            if (totalSize % h == 0) {
                int w = totalSize / h;
            
                // 핵심 조건 체크: 안쪽 노란색 격자 수가 yellow와 일치하는가?
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
    
        return answer;
    }
}