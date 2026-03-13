import java.util.HashSet;

class Solution {
    
    // 중복 제거를 위한 자료구조 'Set' 이용
    HashSet<Integer> numberSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        // [문제 분석]
        
        // 한자리 숫자가 적힌 종이 조각이 흩어져 있음.
        // [지문] '흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지'
        // => DFS, 재귀를 통해 가능한 수를 모두 탐색
        // => '소수' 임을 검증하는 메서드 필요
        
        // (1). DFS 재귀 탐색을 시작
        // 숫자의 조합을 통해 소수를 찾아야 하므로 (조합, 주어진 문자열) 을 보낸다
        recursive("", numbers); 
                
        // (4). 가능한 모든 조합이 담긴 Set 내부의 수들을 검증하여 소수이면 answer 값 증가
        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        
        // [제한 사항]
        // numbers는 길이 1 이상 7 이하인 문자열입니다.
        // => 조건에 8이하로 주어졌을때는 완전탐색을 사용할 수 있다는 의미로 해석할 수 있음.

        // "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미.
        // 예제 #2 [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
        // 11과 011은 같은 숫자로 취급합니다.
        // => 중복 제거 처리를 위한 'Set' 자료구조 및 맨 앞 '0' 처리를 위해 Integer.parseInt 사용 필요
        
        // 최종 반환.
        return answer;
    }
    
    public void recursive(String comb, String others) {
        // (2). 재귀 내부에서 검증을 통해 Set 에 수들을 저장한다 (Set이 알아서 중복 제거).
        // 어떤 검증? 빈 문자열이 아니면 일단 모두 집어넣는다.
        if (!comb.equals("")) {
            // 여기서 Integer.parseInt 변환이 필요해 보임
            // => 일단 중복 제거를 위해서 Set에 저장하는데 문자열도 가능하지만 정수가 효율적이면서 더 유리하고
            // => "011" 이런식으로 들어왔을때 숫자로 변환해주면서 0이 자연스럽게 제거가 되기 때문에
            numberSet.add(Integer.parseInt(comb));
        }
        
        // (3). 반복문 내에서 재귀 함수 호출을 통해 모든 가능한 조합을 탐색
        for (int i = 0; i < others.length(); i++) {
            
            // 재귀 호출
            // =>  재귀(기존 문자에 다음 문자를 붙임, 붙인 해당 문자는 다음 탐색에 제외시킴)
            recursive(comb + others.charAt(i),
                     others.substring(0, i) + others.substring(i + 1));
        }
    }
    
    // 소수임을 검증하는 메서드
    public boolean isPrime(int num) {
        // 넘어온 수가 2 미만일시 바로 실패 반환
        if (num < 2) { return false; }
        
        for (int i = 2; i <= (int) Math.sqrt(num); i++) { 
            // 소수는 1과 자기 자신만이 약수를 갖는 수인데
            // 자기 자신이 아닌 다른 수(다른 약수)로 나눠진다는 건 소수임이 아님을 증명
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}