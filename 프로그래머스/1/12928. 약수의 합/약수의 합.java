class Solution {
    public int solution(int n) {
        int answer = 0; // 리턴받을 answer 값 지정 
        
        for(int i=1; i<=n; i++) { // 반복문을 지정해서 i=1 부터 n까지 증감식 작성 
            if(n%i == 0){ // 입력받은 n의 값을 i번째 값으로 나누었을때 나머지가 0인 값들만 answer 더하면서 이 과정을 n번째까지 반복!
                answer += i;
            }
        }
        return answer; // 정수 n을 입력받아 n의 약수를 모두 더한 값을 answer로 리턴 
    }
}