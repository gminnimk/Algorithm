class Solution {
    public int solution(int[][] sizes) {
        int finalWidth = 0;
        int finalHeight = 0;
        
        for (int[] card : sizes) {
            int curMax = Math.max(card[0], card[1]);
            int curMin = Math.min(card[0], card[1]);
            
            finalWidth = Math.max(finalWidth, curMax);
            
            finalHeight = Math.max(finalHeight, curMin);
        }
        
        return finalWidth * finalHeight;
    }
}