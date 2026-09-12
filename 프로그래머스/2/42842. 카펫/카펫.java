/* [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- 갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
- 노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
=> O(N + M) 은 2,005,000 이므로 O(N^2) 불가능, O(N logN) 까지 시간복잡도 가능

- 카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
=> 가로를 w , 세로를 h라고 했을때, w >= h
*/


/* [ 문제 ]

- brown: 카펫의 갈색 격자의 수
- yellow: 카펫의 노란색 격자의 수 

- 중앙에는 노란색 / 테두리 1줄은 갈색
- 색칠된 격자의 각 개수는 기억하지만, 전체 카펫의 크기는 기억 X

- 주어진 값들에서 구할 수 있는 값
-- (1). brown + yello = totalArea(카펫의 전체 크기)
-- 카펫의 전체 가로를 w, 전체 세로 길이를 h 라고 하였을때, 노란색 테두리 1줄만 반드시 갈색이므로
-- (2). (w - 2) * (h - 2) == yellow 공식을 도출할 수 있음

- 구해야 할 값: 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
*/


/* [ 메모리 멘탈 모델 ]

- 1. 주어진 값들 이용해 공식을 도출한다 (totalArea, 노란색 카펫 크기)
- 2. 반복문을 통해 가로와 세로 길이를 구한다 (이떄 w >= h)

*/

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int totalArea = brown + yellow;
        for (int h = 1; h <= Math.sqrt(totalArea); h++) {
            // 약수가 아니라면 pass
            if (totalArea % h != 0) {
                continue;
            }
            
            int w = totalArea / h;
            if ((w - 2) * (h - 2) == yellow) {
                answer[0] = w;
                answer[1] = h;
            }
        }
        
        return answer;
    }
}