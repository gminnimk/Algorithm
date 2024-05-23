class Solution {
    public int solution(long num) { // 주어진 숫자 num에 대해 작업을 수행하여 결과를 반환하는 메소드
        int answer = 0; // 작업 횟수를 저장할 변수 answer를 0으로 초기화
        
        while(num != 1) { // num이 1이 아닐 때까지 반복
            if(num % 2 == 0) // num이 짝수인 경우
                num /= 2; // num을 2로 나눔
            else // num이 홀수인 경우
                num = num * 3 + 1; // num에 3을 곱하고 1을 더함
            answer++; // 작업 횟수 증가
            
            if(answer >= 500) { // 만약 작업 횟수가 500번 이상이면
                answer = -1; // answer를 -1로 설정하고
                break; // 반복문을 종료
            }
        }
        
        return answer; // 작업 횟수를 반환 (500번 이상이면 -1 반환)
    }
}