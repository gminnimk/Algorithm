class Solution {
    public int solution(int[][] sizes) {
        
        // [문제 분석]
        // 다양한 모양과 크기의 명함들을 모두 수납할 수 있으면서, 작아서 들고 다니기 편한 지갑을 만들어야 함.
        // 2번 명함을 가로로 눕혀 수납한다면 80 x 50 모든 명함들을 수납할 수 있음.
        // => 정규화 개념 적용
        
        // sizes: 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열
        // 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return
        
        
        // [제한 사항]
        // sizes의 길이는 1 이상 10,000 이하입니다: O(N^2)도 가능
        //     sizes의 원소는 [w, h] 형식입니다.
        //     w는 명함의 가로 길이를 나타냅니다.
        //     h는 명함의 세로 길이를 나타냅니다.
        //     w와 h는 1 이상 1,000 이하인 자연수입니다.
        
        
        // [코드 흐름]
        // 코드 전체 시간 복잡도: O(N)
        
        // (1). 정규화 적용 및 가장 큰 가로 및 세로를 찾기: O(N)
        int maxW = 0;
        int maxH = 0;
        for (int[] size : sizes) {
            // 가로, 세로
            int w = Math.max(size[0], size[1]);
            int h = Math.min(size[0], size[1]);
            
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        return maxW * maxH;
    }
}