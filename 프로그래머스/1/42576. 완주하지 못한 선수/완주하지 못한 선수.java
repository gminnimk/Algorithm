import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // [문제 분석]
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주함.
        
        // participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
        // completion: 완주한 선수들의 이름이 담긴 배열
        
        // 완주하지 못한 선수의 이름을 return
        
        
        // [제한 사항]
        // 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.: 해시 사용을 유추할 수 있음
        // completion의 길이는 participant의 길이보다 1 작습니다.
        // 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
        // 참가자 중에는 동명이인이 있을 수 있습니다.: key, value => map 사용
        
        
        // [코드 흐름]
        // (1). 해시 맵 선언 및 참가자 배열 이관
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // (2). 맵과 완주자 배열 비교 및 중복되는 값 제거
        for (String player : completion) {
            // map에 player 값이 있으면 - 1 처리
            map.put(player, map.get(player) - 1);
        }
        
        // (3). 맵에 남은 key(완주하지 못한 선수의 이름) 값 return
        for (String key : map.keySet()) {
            // 값이 0이 아닐때
            if (map.get(key) != 0) {
                return key;
            }
        }
        
        return "";
    }
}