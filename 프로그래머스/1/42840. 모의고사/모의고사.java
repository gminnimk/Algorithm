import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        // [문제 분석]
        // 각 수포자의 찍는 패턴이 존재함
        // answers: 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열
        // => 각 수포자의 패턴과 answers 정답지를 비교해서 맞으면 점수를 증가시키는 로직
        
        // 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return
        // => 각 수포자 별 점수를 담을 배열이 필요함
        
        
        // [제한 조건]
        // 시험은 최대 10,000 문제로 구성되어있습니다: O(N^2) 가능
        // 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
        // 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
        // => 여럿이 몇명인지 모르니 동적 배열 필요 및 정렬은 순차적으로 삽입하도록
        
        
        // [코드 흐름]
        // (1). 각 수포자 정답 패턴 기록
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 점수판 생성
        int[] scores = new int[3];
        
        // (2). 각 수포자의 정답 패턴과 실제 정답지를 비교하여 점수판 갱신
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) { scores[0]++; }
            if (answers[i] == p2[i % p2.length]) { scores[1]++; }
            if (answers[i] == p3[i % p3.length]) { scores[2]++; }
        }
        
        // (3). 점수판에서 최대값 구하기
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
    
        // (4). 동적 배열 생성 및 오름차순
        List<Integer> list = new ArrayList<>();
        if (scores[0] == maxScore) { list.add(1); }
        if (scores[1] == maxScore) { list.add(2); }
        if (scores[2] == maxScore) { list.add(3); }
        
        int[] answer = new int[list.size()];
        // (3). 반환은 배열로 해야 하므로 다시 배열 형태
        for (int n = 0; n < list.size(); n++) {
            answer[n] = list.get(n);
        }
        
        return answer;
    }
}