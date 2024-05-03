class Solution {
    public double solution(int[] arr) {
        // 배열 arr에 대한 for문을 작성하고 for문 안에서 return 하는 값을 배열의 값들을 계속해서 더해 줌 
        // 그 이후에 return 값을 반복문 처리 된 배열에 배열의 크기만큼 나누면 => 평군 
        
        // 구현 
        
        double answer = 0; // return 할 값인 answer을 소수점도 나타내기 위해 double형으로 선언 
        
        for (int i=0; i<arr.length; i++){
            answer += arr[i]; // answer 에 배열 arr[i] (배열arr에 i번째 값까지 반복하여 더해짐)
        }
        answer = answer/arr.length; //answer  = 배열에 있는 값들이 모두 더해진 값 에 나누기 arr.length 즉 평균을 구한다라는 뜻  
        return answer;

    }
}