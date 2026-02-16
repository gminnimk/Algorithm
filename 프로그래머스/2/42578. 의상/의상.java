import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // 각 종류별 최대 1가지 의상만 착용 가능 => 카테고리별 분류
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1); // 종류 별 저장
        }
        
        // 하루에 최소 한 개의 의상은 입는다 => 안 입는 경우도 존재
        int answer = 1;
        for (int cloth : map.values()) {
            answer *= cloth + 1; // 경우의 수 및 안입는 경우 최신화
        }
    
        // 서로 다른 옷의 조합의 수 return (모든 조합의 수에서 아예 안 입는 수는 제거)    
        return answer - 1;
    }
}