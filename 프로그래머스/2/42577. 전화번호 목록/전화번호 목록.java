import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // [문제 분석]
        // 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 존재?
        // 같은 전화번호가 중복해서 들어있지 않음: 전화번호부를 중복 제거를 해주는 자료구조로 옮겨야 하지 않을까
        
        // phone_book: 전화번호를 담은 배열 (길이: 1 이상 ~ 1,000,000 이하) => O(1) 해결법 필요 판단
        // 어떤 번호가 다른 번호의 접두어인 경우가 존재: false
        // else: true
        
        
        // [문제 정리]
        // 해시 셋(중복 X) 내 전화번호부의 특정 전화번호를 꺼내고 다른 전화번호의 "접두어" 인 경우를 substring, contains를 활용해서 찾는 문제,
        
        
        // [코드 흐름]
        boolean answer = true;
        // (1). 중복 제거를 위한 해시 셋 선언 및 전화번호부 배열 이관 (제한 사항)
        HashSet<String> set = new HashSet<>();
        for (String number : phone_book) {
            set.add(number);
        }
        
        // (2). 특정 전화번호를 꺼내서 전화번호부 내의 나머지 전화번호와 비교하여 접두어 찾기
        for (int i = 0; i < phone_book.length; i++) {
            // 다른 전화번호와 비교하면서 찾는 과정에서는 본인 전화번호를 비교하면 안 됨
            String current = phone_book[i]; // 현재 기준으로 잡은 전화번호
            
            // "접두어"만 확인하면 되니까
            for (int j = 1; j < current.length(); j++) {
                // 접두어 존재한다면? (본인은 제외)
                if (set.contains(current.substring(0, j))) {
                    return false;
                }
            }
        }
        
        return answer;
    }
}