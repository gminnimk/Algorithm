import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // [제한 사항]
        // 같은 전화번호가 중복해서 들어있지 않음: Map Or Set 을 사용
        HashMap<String, Integer> map = new HashMap<>();
        boolean answer = true;
        
        // [문제 분석]
        // 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인
        // : substring 사용
        
        // (1). map에 전화번호를 모두 저장한 후 반복문을 통해 하나씩 꺼낸다
        for (String number : phone_book) {
            map.put(number, 1);
        }
        
        for (int i = 0; i < phone_book.length; i++) {
            String currentNum = phone_book[i];
            
            // (2). 꺼낸 전화번호를 substring 으로 쪼꺤다
            for (int j = 1; j < currentNum.length(); j++) {
                String words = currentNum.substring(0, j);
                // (3). 쪼개는 순간마다 map에 저장해둔 전화번호가 존재하는지 확인을 반복한다 (자기 자신은 제외하고)
                if (map.containsKey(words)) {
                    return false;
                }
            }
        }
    
        return answer;
    }
}