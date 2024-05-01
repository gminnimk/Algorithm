class Solution {
    public double solution(int[] numbers) {
        double answer = 0; 
        int cnt = 0; 
        int sum = 0; 
        
        cnt = numbers.length; 
        
        for(int n : numbers){
            sum += n; 
        }
        
        answer = (double) sum / cnt; 
        
        return answer; 
    }
}