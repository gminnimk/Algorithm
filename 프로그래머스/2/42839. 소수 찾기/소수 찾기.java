import java.util.*;

class Solution {
    
    // => 조합의 개수 중 모든 탐색 중 중복되는 수가 있을 수 있으니 'Set 자료구조'를 활용하여 중복을 제거
    HashSet<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        
        // [문제 분석]
        // 한자리 숫자가 적힌 종이 조각이 흩어져 있음.
        // 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 파악하기.
        // => 가능한 모든 숫자 순열을 생성해야 하므로 DFS/재귀
        // 재귀를 수행할 요소로 (조합된 문자, 주어진 문자열);
        int answer = 0;
        recursive("", numbers);
        
        // => 소수 파악은 제곱근을 이용한 소수 판별
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        // [제한 사항]
        // numbers는 길이 1 이상 7 이하인 문자열입니다.: 8이하로 조건이 주어진다면 완전탐색을 사용해도 된다는 의미로 볼 수 있음
        // numbers는 0~9까지 숫자만으로 이루어져 있습니다.
        // "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
        
        // 종이 조각으로 만들 수 있는 소수가 몇 개인지 return
        return answer;
    }
    
    // 재귀 함수를 통해서 모든 조합의 수를 통해 소수 찾기
    public void recursive(String comb, String others) {
        // 조합된 조합이 빈 문자열이 아니면 셋에 전부 추가
        if (!comb.equals("")) {
            numberSet.add(Integer.parseInt(comb));
        }
        
        // 재귀
        // Ex) others = "173"
        // (1). ("" + "1", "73"), ~ (그 외 다른 선택지 일 경우)
        // (2). ("17", "3"), ~  
        // (3). ("173", ""), ~  
        for (int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), 
                      others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    // 소수 검사 메서드 (넘어온 수가 소수인가?)
    public boolean isPrime(int num) {
        if (num < 2) { return false; }
        
        for (int i = 2; i <= Math.sqrt(num); i++ ) {
            if (num % i == 0) { return false; }
        }
        
        return true;
    }
}