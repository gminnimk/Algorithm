import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        // [문제 분석]
        
        // 같은 전화번호가 중복해서 들어있지 않음: Map or Set
        // => (1). HashMap 을 사용하여 기존 전화번호부를 전부 다 배열에 삽입한다.
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String number : phone_book) {
            map.put(number, 1); 
        }
        
        // 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우를 찾는다.
        // (2). 반복문으로 전화번호를 하나씩 꺼낸 후 substring 을 이용해서 쪼갠다
        for (int i = 0; i < phone_book.length; i++) {
            String currentNumber = phone_book[i]; // 꺼내옴
            
            // 꺼내온 번호 쪼개기 작업 시작
            // [제한 사항]
        // 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인: substring()
            for (int j = 1; j < currentNumber.length(); j++) {
                
                // (3). 쪼개는 순간마다 Map 에 동일한 전화번호가 존재하는지 확인한다.
                String words = currentNumber.substring(0, j);
                
                // (4). 존재하면 false, 모두 확인해도 업으면 true
                if (map.containsKey(words)) {
                    return false;
                }
            }
        }
        return answer;  
    }
}