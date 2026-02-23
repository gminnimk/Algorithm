import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // [문제 분석]
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주함.
        
        // participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
        // completion: 완주한 선수들의 이름이 담긴 배열
        
        // 완주하지 못한 선수의 이름을 return
        
        
        // [제한 사항]
        // 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
        // => O(N logN) 까지 가능
        
        // 참가자 중에는 동명이인이 있을 수 있습니다.
        // => key, value (key 중복 가능)
        
        
        
        // [코드 흐름]
        // 현재 코드의 최종 시간 복잡도: O(N)
        HashMap<String, Integer> map = new HashMap<>();
        // (1). 참가자 추가: N명 반복 * O(1) = O(N)
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // (2). 완주자 차감: (N-1)명 반복 * O(1) = O(N)
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        // (3). key값은 유지되어 있으므로 value 값을 기준으로 남아있는 값 반환
        // 완주하지 못한 선수의 '이름' 을 반환해야 하므로 남아있는 key값 꺼내기
        // => key의 value 값이 0 이 아니면 출력하는 조건문 이용
        // Key 탐색 = O(N)
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return "";
    }
}