class Solution {
    public int[] solution(int brown, int yellow) {
        
        int[] answer = new int[2];
        
        // [문제 분석]
        // 중앙에는 노란색, 테두리 1줄은 갈색
        
        // 노란색과 갈색의 격자의 수는 기억하지만, 전체 카펫의 크기는 기억 X
        // brown: 카펫에서 갈색 격자의 수
        // yellow: 노란색 격자의 수
        // => 구할 수 있는 식
        // (1). 전체 카펫의 크기: brown + yellow
        int total = brown + yellow;
        
        // (2). 중앙(노란색)에 대한 크기 식 (테두리는 최소 2만큼 더 크기에)
        // 카펫의 가로를 w, 세로를 h라고 지정
        // : (w - 2) * (h - 2) = yellow
        // (2-1). 가로 * 세로
        // : w * h = total;
        
        // 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
        
        // 제곱근까지 탐색 (테두리는 최소 중앙의 (가로,세로) + 2, 가로는 세로보다 크거나 같아야 하므로)
        for (int h = 3; h <= Math.sqrt(total); h++) {
            
            // 높이가 전체 너비의 약수이면
            if (total % h == 0) { 
                int w = total / h;
                
                // 주어진 노란색 값이 맞으면 배열에 가로, 세로 값 담기
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        // [제한 사항]
        // 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
        // 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다. : O(N^2) 불가능
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.: w >= h

        return answer;
    }
}