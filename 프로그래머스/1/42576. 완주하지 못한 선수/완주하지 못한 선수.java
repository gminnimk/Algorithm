import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // [문제 분석]
        // 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주
        
        // participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
        // completion: 완주한 선수들의 이름이 담긴 배열
        
        // 완주하지 못한 선수의 이름을 return
        
        
        // [제한 사항]
        // 참가자 중에는 동명이인이 있을 수 있음
        // => key, value
        
        
        // [코드 흐름]
        // (1). 해시맵에 기존 참가자 배열 이관
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // (2). 이관한 맵에서 완주자를 차감
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        // (3). 남은 맵에 있는 key(String)를 리턴
        for (String key : map.keySet()) {
            if (map.get(key) != 0) { // 아직 완주하지 못 한 참가자
                return key;
            }
        }
        
        return "";
    }
}