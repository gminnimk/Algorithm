import java.util.*;

class Solution {
    public int[] solution(int[] answers) {        
        // [문제 분석]
        
        // 1번 수포자, 2번 수포자, 3번 수포자
        // => 수포자 찍는 반복 패턴 기록 필요
        int[] p1 = {1, 2, 3, 4, 5};
        int[] p2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] p3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        // 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어 졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 함수 작성
        // (1). 가장 많은 문제를 맞힌 사람이 누구인지 알기 위해: scores[] 배열
        int[] scores = new int[3]; // 수포자가 3명이므로
        
        // 문제 맞힌 갯수 계산 시작
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == p1[i % p1.length]) { scores[0]++; }
            if (answers[i] == p2[i % p2.length]) { scores[1]++; }
            if (answers[i] == p3[i % p3.length]) { scores[2]++; }            
        }
        
        // 이후 최대 값 추출
        int maxScore = Math.max(scores[0], Math.max(scores[1], scores[2]));
        
        // [제한 조건]
        // 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬
        // (2). 여럿일 경우 사람의 수를 예측할 수 없기에 동적 list를 이용
        List<Integer> list = new ArrayList<>();
        if (maxScore == scores[0]) { list.add(1); }
        if (maxScore == scores[1]) { list.add(2); }
        if (maxScore == scores[2]) { list.add(3); }
        
        int[] answer = new int[list.size()];
        // (3). 반환은 배열로 해야 하므로 다시 배열 형태로 변환 후 반환
        for (int n = 0; n < list.size(); n++) {
            answer[n] = list.get(n);
        }    
        
        return answer;
    }
}