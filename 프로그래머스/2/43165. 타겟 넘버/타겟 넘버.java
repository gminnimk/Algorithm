class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        
        // [문제 분석]
        // n개의 음이 아닌 정수들이 존재.
        // 정수들 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 함.
        // => DFS (깊이 우선 탐색은 순서를 바꾸지 않으며 백트리킹 개념으로 더하거나 빼서 탐색가능)
        // 두가지의 경로 dfs(더하기), dfs(빼기) 재귀가 필요함
        
        // numbers: 사용할 수 있는 숫자가 담긴 배열
        // target: 타겟 넘버
        
        // 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하시오
        
        // (1). dfs 탐색을 시작하기전 넘겨줘야 할 매개변수
        // 재귀를 돌면서 계속 타겟넘버가 맞는지 확인해야 하니까 여태까지의 합을 저장하는 변수와
        // 재귀를 탈출하기 위해 numbers 배열의 길이와 동일한지 검증하는 인덱스 변수
        // numbers, target, sum, index
        dfs(numbers, target, 0, 0);
        
        return count;
    }
    
    public void dfs(int[] numbers, int target, int sum, int index) {
        // 재귀 탈출 조건문 
        // 타겟 넘버가 맞는지는 모든 배열의 끝까지 탐색하고 검증 해야 함 (중간에 타겟넘버가 되었다고 검증 X)
        if (numbers.length == index) {
            if (sum == target) {
                count++;
            }
            
            // 타겟 넘버가 아니면 이전 재귀로 돌아가기
            return;
        }
        
        // 두 방향의 탐색 경로
        dfs(numbers, target, sum + numbers[index], index + 1);
        dfs(numbers, target, sum - numbers[index], index + 1);
    }
}