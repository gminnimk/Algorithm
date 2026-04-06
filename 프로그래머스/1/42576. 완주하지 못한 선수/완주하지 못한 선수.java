import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // [문제 분석]
        // "단 한 명의 선수를 제외하고는 모든 선수가 마라톤에 완주"
        // participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
        // completion: 완주한 선수들의 이름이 담긴 배열
        
        // 완주하지 못한 선수의 이름을 return 
        
        
        // [제한 사항]
        // 1명 이상 100,000명 이하 => O(N^2) X, O(1)
        // 참가자 중에는 동명이인이 존재 => 중복 제거 X
        
        
        // [문제 정리]
        // 주어진 두 배열을 비교하여 하나의 배열에 없는 값을 return 하는 문제 (key 중복 허용)
        // (입력값 크기를 고려해서 O(1), 중복 허용)
        // => HashMap, (key, value)
        
        
        // [코드 흐름]
        // (1). 주어진 참가자 배열을 HashMap 에 전부 이관한다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        
        // (2). 이관한 HashMap을 completion의 key의 value 값을 모두 차감한다.
        for (String player : completion) {
            map.put(player, map.get(player) - 1);
        }
        
        // (3). 남은 key 값을 return 한다
        for (String key : map.keySet()) {
            
            // map 에 value 값이 0이 아니라면 (해당 완주하지 못 한 참가자가 존재한다면)
            if (map.get(key) != 0) {
                return key; // 어짜피 문제에서 1명이라고 했기에
            }
        }
        
        return "";
    }
}