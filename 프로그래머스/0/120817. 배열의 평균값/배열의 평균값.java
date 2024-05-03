class Solution {
    public double solution(int[] numbers) { // 정수 배열 numbers가 매개변수로 주어짐. 
        
        // numbers의 원소의 평균값을 return 하도록 구현! 
        
        // for문을 활용하여 배열에 모든 값들을 해당길이까지 더하여 리턴하도록 저장한 후에 
        // 길이만큼 다시 나누어서 리턴 하면 원소의 평균값을 구할 수 있음! 
        double answer = 0; 
        
        for(int i=0; i<numbers.length; i++){
            answer += numbers[i]; 
        } 
        
        answer = answer / numbers.length;
        
        return answer; 
         

    }
}