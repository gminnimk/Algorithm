class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n]; // n크기의 long type 배열 answer 선언 
       
        for(int i=0; i<n; i++) { // for 반복문 선언 
        	answer[i] = x*(i+1); // i번쨰 answer 배열이 x*(i+1) 값이 증가하면서 계속 배열에 추가. 
        }     
        return answer;
    }
}