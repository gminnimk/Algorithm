import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // [문제 분석]
        // 이름과 종류 (String, String) => key, value (HashMap)
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        int answer = 1; // (2). 하루에 최소 한 개의 의상은 입는다.
        
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
        
        return answer - 1; // 아무것도 입지 않은 경우 
    }
}