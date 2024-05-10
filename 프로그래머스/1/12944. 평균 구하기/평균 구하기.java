class Solution {
    public double solution(int[] arr) {
        
        //평균값을 return 해줄 변수 생성 
        double answer = 0; // 예시에 결과값 소수점이 있으니 double형 사용. 
        for(int i=0; i<arr.length; i++){ 
            answer += arr[i];  // answer에 배열 arr i번째 값들을 넣어 줌. 
        }
        answer = answer/arr.length;  // answer 에 위 반복문에서 정의된 answer와 arr의 길이를 나눈값으로 정의 
        
        return answer; 
    }
}