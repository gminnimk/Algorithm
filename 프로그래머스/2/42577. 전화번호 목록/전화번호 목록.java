import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // [문제 분석]
        // 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 겨우가 있는지 확인
        
        // phone_book: 전화번호부에 적힌 전화번호를 담은 배열
        // 어떤 번호가 다른 번호의 접두어인 경우 false
        // 그렇지 않으면 true return
        
        
        // [제한 사항]
        // phone_book의 길이 1 ~ 1,000,000 이하
        // => O (N^2) 시간 초과, O(N) 이 적합
        
        // 같은 전화번호가 중복해서 들어있지 않습니다
        // => HashSet
        
        
        // [코드 흐름] 
        // 코드 전체 시간 복잡도: O(N)
        
        // (1). 해시셋 선언 및 전화번호 배열 이관
        // 해시(O(1)) & 1차 루프(O(N)): O(N)   
        HashSet<String> set = new HashSet<>();
        for (String number : phone_book) {
            set.add(number);
        }
        
        // (2). 이중 탐색 구조를 기반하여 전화번호부에 하나의 전화번호를 선택하고
        // 해당 전화번호를 기준으로 다른 번호의 접두어가 충족되는지 검사한다
        
        // 루프(1,000,000) * 전화번호 길이(20): O(N)
        for (String num : phone_book) {
            String number = num;
            // k가 1부터인 이유는 자기 자신을 검사에서 제외하기 위해
            for (int k = 1; k < number.length(); k++) {
                if (set.contains(number.substring(0, k))) {
                    return false;
                }
            }
        }
        
        return true;
    }
}