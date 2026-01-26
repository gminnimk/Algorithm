import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 참가자 중에 동명이인이 있을 수 있음
        // 1. 참가자들 배열에 삽입
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        
        // 2. 완주자 목록 기반 제거
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }
        
        // 3. value 가 0이 아닌 사람
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}