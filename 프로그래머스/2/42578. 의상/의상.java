import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        // 1. 의상 종류별 개수를 카운팅하기 위한 HashMap 선언
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            // 해당 종류가 이미 존재하면 기존 값에 1을 더하고, 없으면 1로 초기화
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1;
        
        // 2. 조합 공식 적용: 각 종류별 (개수 + 1)을 모두 곱함
        for (int count : map.values()) {
            answer *= (count + 1);
        }
        
        // 아무것도 입지 않은 경우
        return answer - 1;
    }
}