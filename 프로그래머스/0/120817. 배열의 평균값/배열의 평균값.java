class Solution {
    public double solution(int[] numbers) { // 정수 배열 numbers가 매개변수로 주어짐. 
        double answer = 0; // numbers의 원소의 평균값을 return 받을 변수
        
        for(int i=0; i<numbers.length; i++){ // numbers 배열의 길이만큼 반복문이 수행이 되게
            answer += numbers[i];   // answer라는 변수에 배열 numbers의 i번째 배열을 반복하여 저장
        }
        answer = answer/numbers.length; // answer 변수에 위 반복문에서 수행한 answer에 배열 numbers의 길이만큼 나눠줌 
        return answer; // answer 최종 반환 
    }
}