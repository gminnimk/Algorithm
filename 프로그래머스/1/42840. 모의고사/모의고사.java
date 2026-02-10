import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        // [문제 분석]
        // 각 수포자가 찍는 방식: 반복 패턴 정리
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 가장 높은 점수 받은 사람을 알아야 하므로
        int[] scores = new int[3];
        
        // 실제 답변과 수포자의 답안을 비교하여 점수판 최신화
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) { scores[0]++; }
            if (answers[i] == p2[i % p2.length]) { scores[1]++; }
            if (answers[i] == p3[i % p3.length]) { scores[2]++; }
        }
        
        // 점수판 기록이 끝나면 최대값 구하기
        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // 최대값 구했으니 가장 높은 점수를 받은 사람을 반환
        List<Integer> list = new ArrayList<>();
        if (scores[0] == max)  { list.add(1); }
        if (scores[1] == max)  { list.add(2); }
        if (scores[2] == max)  { list.add(3); }
        
        // list가 아닌 배열 형태로 반환 해야 하므로
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}