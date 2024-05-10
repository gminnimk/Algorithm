class Solution {
    public String solution(int num) {
        if (num % 2 == 0){ //num이 2로 나누었을때 나머지가 0 , 즉 짝수! 
            return "Even"; 
        } else { 
            return "Odd";
        }
    }
}