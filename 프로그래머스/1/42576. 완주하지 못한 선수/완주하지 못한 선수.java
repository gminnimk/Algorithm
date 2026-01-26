import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        // 완주하지 못 한 선수의 이름을 리턴
        // 참가자에서 완주자를 빼고 남은 값을 리턴
        
        HashMap<String, Integer> hm = new HashMap<>();
        
        // 1. 참가자 정보 먼저 주입
        for (String player : participant) {
            hm.put(player, hm.getOrDefault(player, 0) + 1);
        }
        
        // 2. 참가자에서 완주자 제거
        for (String player : completion) {
            hm.put(player, hm.get(player) - 1);
        }
        
        // 3. 제거를 완료 했으니 이제 map 에서 남은 value 값 추출
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0) {
                answer = key;
                break;
            }
        }
        
        return answer;
    }
}