import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        // [문제 분석]
        // phone_book: 전화번호부에 적힌 전화번호를 담은 배열
        // 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false
        // 그렇지 않으면 true를 return
        
        // [제한 사항]
        // phone_book: 1 ~ 1,000,000 이하: O(1)로 해결 필요
        // 같은 전화번호가 중복해서 들어있지 않음: Set
        
        
        // [코드 흐름]
        // 전화번호부의 전화번호를 set에 전부 이관해서 중복 체크
        HashSet<String> set = new HashSet<>();
        for (String number : phone_book) {
            set.add(number);
        }
        
        // 이후 하나의 번호를 꺼낸 후 substring을 활용하여 일정 범위만큼 잘라서
        for (int i = 0; i < phone_book.length; i++) {
            String currentNum = phone_book[i];
            
            // substring을 활용해서 문자를 잘라야 하므로 1부터 시작 및 자기 자신은 제외
            for (int j = 1; j < currentNum.length(); j++) {
                // 기존 Set에 같은 문자열이 있는지 체크
                if(set.contains(currentNum.substring(0, j))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}