import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // [문제 분석]
        
        // 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우를 확인
        
        // phone_book: 전화번호부에 적힌 전화번호를 담은 배열
        // 어떤 번호가 다른 번호의 접두어인 경우 false
        // 그렇지 않으면 true를 return
        
        
        // [제한 사항]
        // phone_book의 길이는 1 이상 1,000,000 이하입니다.
        
        // [코드 흐름]
        // (1). 해시맵을 선언 후 전화번호 목록을 모두 이관
        // (2). 반복문을 통해서 특정 번호를 기준으로 다른 번호와 요소를 비교한다
        // => substring
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String number : phone_book) {
            map.put(number, 1);
        }
        
        for (String number : phone_book) {
            // 전화번호부 목록에서 번호를 하나 꺼냈으니 해당 번호 요소 까지
            for (int j = 1; j < number.length(); j++) {
                if (map.containsKey(number.substring(0, j))) {
                    return false;
                };
            }
        }
        
        // 접두어가 존재하지 않다면
        return true;
    }
}