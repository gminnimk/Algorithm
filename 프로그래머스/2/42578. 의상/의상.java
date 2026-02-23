import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        
        // [문제 분석]
        // 코니는 매일 다른 옷을 조합하여 입는다
        // => 경우의 수 구하기
        
        // 각 종류별 최대 1가지 의상만 착용할 수 있다
        // => key, value 에서 key를 종류로 정의하고 의상의 이름은 버리기
        
        // 하루에 최소 한 개의 의상은 입는다
        // => 그렇다면 다른 종류에서는 안 입는 경우도 존재한다
        
        // clothes: 의상들이 담긴 2차원 배열
        // 서로 다른 옷의 조합의 수를 return
        
        
        // [제한 사항]
        // 같은 이름을 가진 의상은 존재 X
        // => 종류를 기준으로 key로 설정하면 해결
        // 코니가 가진 의상의 수 1개 이상 30개 이하: 복잡도 제한 X
        
        // [코드 흐름]
        // 코드의 전체 시간 복잡도: O(N)
        
        // (1). 해시맵 선언 및 의상 배열 이관
        // 해시(O(1)) + 루프(O(N)): O(N) 
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] cloth : clothes) {
            String type = cloth[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }
        
        // (2). 경우의 수 구하기 로직
        // 루프: O(N)
        int answer = 1;
        for (int val : map.values()) {
            answer *= (val + 1); // 종류 별 안 입는 경우도 포함
        }
        
        return answer - 1; // 아예 안 입는 경우 제거
    }
}