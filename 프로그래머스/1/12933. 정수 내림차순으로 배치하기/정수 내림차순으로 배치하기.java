import java.util.*;

class Solution {
    // 정수 n을 받아들여 처리하는 solution 메서드
    public long solution(long n) {
        long answer = 0; // 결과 값을 저장할 변수 answer를 선언하고 초기화합니다.
        ArrayList<Long> temp = new ArrayList<Long>(); // 각 자리 숫자를 임시로 저장할 ArrayList를 생성합니다.
        
        // n이 10보다 클 때까지 반복합니다.
        while(n>10){
            temp.add(n%10); // n을 10으로 나눈 나머지(일의 자리 숫자)를 temp에 추가합니다.
            n = (n-(n%10))/10; // n에서 일의 자리 숫자를 뺀 후 10으로 나눈 몫을 새로운 n으로 설정합니다.
        }
        temp.add(n); // 남은 숫자(10 이하)를 temp에 추가합니다.
        Collections.sort(temp); // temp에 저장된 숫자들을 오름차순으로 정렬합니다.

        // temp의 각 숫자를 10의 제곱수를 곱하여 자릿수를 조정한 후 answer에 더합니다.
        for(int i=0;i<temp.size(); i++){
            answer += (long)(Math.pow(10,i)*temp.get(i));
        }
        return answer; // 결과 값인 answer를 반환합니다.
    }
}
