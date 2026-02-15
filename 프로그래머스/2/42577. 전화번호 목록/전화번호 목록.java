import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // [문제 분석]
        
        // phone_book: 전화번호부에 적힌 전화번호를 담은 배열
        
        // 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우 false
        // 아니면 true 반환
        
        // [제한 사항]
        // phone_book의 길이는 1 이상 1,000,000 이하입니다.
        // 같은 전화번호가 중복해서 들어있지는 않음
        // => 해시맵
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 전화번호부 해시맵에 이관
        for (String number : phone_book) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        
        // 전화번호부에서 접두어를 지정 후 검사 진행
        for (String number : phone_book) {
            for (int j = 1; j < number.length(); j++) {
                if (map.containsKey(number.substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}