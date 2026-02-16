import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // [지문 분석]
        
        // clothes: 코니가 가진 의상들이 담긴 2차원 배열
        // [의상의 이름(value), 의상의 종류(key)] 로 구성
        
        // (1). 각 종류별로 최대 1가지 의상만 착용할 수 있음 => 종류 기준 분류
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // 서로 다른 종류의 옷 조합의 수 구하기 시작 (종류별 개수 가져오기(0 ~ 최대 1가지))
        int answer = 1;
        for (int cloth : map.values()) {    
            // (2). 하루에 최소 한 개의 의상은 입는다 => 다른 의류에서는 압 입는 경우도 존재한다는 것
            answer *= cloth + 1;
        }
        
        // (3). 서로 다른 옷의 조합의 수를 return => 모든 조건에서 아예 안 입는 경우 -1
        return answer - 1;
    }
}