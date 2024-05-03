class Solution {
    public String solution(int num) {
        // 정수 num이 짝수일 경우 "Even"을 반환!! => 이 경우 String으로 먼저 선언을 해줘야 함. 
        
        // 반환할 값을 선언하기 
        
        String input = ""; 
        
        
        // if문으로 조건 값 찾기 
        
        if (num % 2 == 0){ // 짝수인 경우 
            return input = "Even";
        } else { // 홀수인 경우 
            return input = "Odd";
        }
        
    }
}