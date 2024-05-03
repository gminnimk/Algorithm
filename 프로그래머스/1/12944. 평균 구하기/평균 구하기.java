class Solution {
    public double solution(int[] arr) {
        // 배열을 for문으로 돌리고 answer에 더해주고 answer을 length 만큼 나누기! 
        double answer = 0;
        for(int i = 0; i < arr.length; i++){
            answer += arr[i];
        }
        answer = answer / arr.length;
        return answer;  
    }
}