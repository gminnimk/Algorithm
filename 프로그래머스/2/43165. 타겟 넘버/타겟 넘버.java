class Solution {
    
    // 타겟넘버 횟수를 저장하기 위한 변수
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        // [문제 분석]
        // n개의 음이 아닌 정수들이 존재
        // 순서를 바꾸지 않고 '적절히 더하거나 빼서 타겟 넘버'를 만들기로 함.
        // => DFS, 2개의 탐색 방향
        
        // dfs 탐색을 하면서 필요한 매개변수가 무엇일까?
        // 구하고자 하는 건 모든 배열의 조합을 끝까지 다 돌고 나서 타겟넘버가 되는 횟수임.
        // 그렇다면 재귀를 통제하기 위한 변수와 타겟넘버를 확인하기 위한 변수가 필요하지 않을까.
        dfs(numbers, target, 0, 0);
        
        // numbers: 사용할 수 있는 숫자가 담긴 배열
        // target: 타겟 넘버
        // 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 
        
        return count;
    }
    
    public void dfs(int[] numbers, int target, int index, int sum) {
        
        // 조건문 (재귀 탈출, 배열을 끝까지 탐색했을 때)
        if (index == numbers.length) {
            // 여태까지의 조합의 합이나 빼기가 target가 일치하는가?
            if (sum == target) {
                count++;
            }
            
            return;
        }
        
        // 두 방향의 탐색
        dfs(numbers, target, index + 1, sum + numbers[index]); // +
        dfs(numbers, target, index + 1, sum - numbers[index]); // -
    }
}