class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
    
    // DFS 메서드
    private int dfs(int[] numbers, int target, int index, int currentSum) {
        
        // [탈출 조건]
        if (index == numbers.length) {
            return (currentSum == target) ? 1 : 0;
        }
        
        // [실제 탐색]
        int plusWay = dfs(numbers, target, index + 1, currentSum + numbers[index]); // +
        int minusWay = dfs(numbers, target, index + 1, currentSum - numbers[index]); // -
        
        // 방법의 수
        return plusWay + minusWay;
    }
}