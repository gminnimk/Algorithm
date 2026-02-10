import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // [문제 분석]
        
        // 가로 길이, 세로 길이가 존재
        // 모든 명함을 수납할 수 이는 가장 작은 지갑을 만들어야 함: 정규화 필요
        
        int maxW = 0;
        int maxH = 0;
        
        // 배열에 있는 모든 명함을 탐색
        for (int[] card : sizes) {
            int w = Math.max(card[0], card[1]); // 가로에 대한 최대 길이
            int h = Math.min(card[0], card[1]); // 세로에 대한 최대 길이
            
            if (w > maxW) { maxW = w; }
            if (h > maxH) { maxH = h; }
            
        }
             
        return maxW * maxH;
    }
}