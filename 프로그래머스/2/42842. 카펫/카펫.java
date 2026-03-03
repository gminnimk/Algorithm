class Solution {
    public int[] solution(int brown, int yellow) {
        
        // [문제 분석]
        // 중앙에는 노란색, 테두리 1줄은 갈색
        // 각 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억 X
        
        // brown: 갈색 격자의 수
        // yellow: 노란색 격자의 수
        
        // 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
        
        
        // < 구할 수 있는 식 >
        
        // (1). 카펫 전체 크기 = brown + yellow;
        
        // w를 카펫의 가로, h를 카펫의 세로라고 가정
        // 중앙은 테두리의 가로, 세로보다 각각 -2씩 작음
        // (2). yellow 크기 = ((w - 2) * (h - 2))
        
        
        // [제한 사항]
        // 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
        // => h <= w
        
        
        // [코드 흐름]
        // 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
        
        // 카펫 전체 크기
        int[] answer = new int[2];
        int total = brown + yellow;
        
        // 반복문 순환을 높이(h) 기준으로 한다
        for (int h = 3; h <= Math.sqrt(total); h++) {
           
            // 높이가 전체 크기의 약수이면
            if (total % h == 0) {
                int w = total / h; // 카펫의 가로
                
                // 카펫의 가로와 세로에서 각각 -2를 하고 곱한 값이 yellow, 즉 중앙인가?
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }   
            }
        }
    
        return answer;
    }
}