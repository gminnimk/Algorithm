import java.util.*;

class Solution {
    
    // 중복 제거르 위한 주머니
    // 지문: "11과 011은 같은 숫자로 취급합니다."
    // 011, 11 모두 정수로 변환하면 11이므로, 중복을 피하기 위해 Set을 사용합니다.
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // 모든 숫자 조합 만들기 시작
        // 지문: "흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 함"
        // 처음에는 만든 숫자가 없으므로 빈 문자열 "", 사용할 조각은 전체를 넘겨주기
        recursive("", numbers);
        
        // 주머니에 담긴 숫자들 중 소수 개수 세기
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 재귀 함수: 종이 조각 붙이는 과정
    // comb: 지금까지 이어 붙인 숫자 문자열
    // others: 아직 테이블에 남아있는 숫자 조각들
    public void recursive(String comb, String others) {
        // 1. 현재까지 이어 붙인 숫자가 있다면 정수로 변환해서 주머니(Set)에 넣습니다.
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }
        
        // 2. 남은 조각(others) 중에서 하나씩 골라 현재 조합(comb) 뒤에 붙입니다.
        for (int i = 0; i < others.length(); i++) {
            // 내가 i번째 조각을 선택했다면?
            // 새로운 조합: 기존 조합 + i번째 조각
            // 남은 조각들: i번째를 제외한 나머지 문자열들(substring 활용)
            recursive(comb + others.charAt(i),
                    others.substring(0, i) + others.substring(i + 1));
            // Ex) numbers = "ABCDE" , i = 2
            // others.substring(0, i): "AB"
            // others.substring(i + 1): 3번째 부터 끝까지, "DE"
            // 둘을 합치면 "ABDE", 즉 i번째만 제거
        }
    }
    
    // 소수 판별 로직
    // 지문: "만들 수 있는 소수가 몇 개인지 return"
    public boolean isPrime(int num) {
        // 0과 1은 소수가 아닙니다.
        if (num < 2) { return false; }
        
        // 에라토스테네스의 채 원리: 제곱근까지만 나누어 떨어지는지 확인 (효율성 최적화)
        for (int i = 2; i <= (int) Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // 나누어 떨어지니까 소수 X
            }
        }
        
        return true;
    }
}