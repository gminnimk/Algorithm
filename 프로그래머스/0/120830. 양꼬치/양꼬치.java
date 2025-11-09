class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int totalLambPrice = n * 12000; // 양꼬치
        int totalDrinkPrice = k * 2000; // 음료
        
        int freeDrinkPrice = n / 10;
        
        answer = totalLambPrice + totalDrinkPrice - (freeDrinkPrice * 2000);
        return answer;
    }
}