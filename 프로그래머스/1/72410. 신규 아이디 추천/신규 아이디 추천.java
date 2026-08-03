class Solution {
    public String solution(String new_id) {
        
        // [문제] 
        // 신규 유저가 입력한 아이디를 나타내는 new_id가 매개변수로 주어질 때, "네오"가 설계한 7단계의 처리 과정을 거친 후의 추천 아이디를 return 하도록 solution 함수를 완성해 주세요.

        // [1단계: 제한사항 분석 및 예측]
        // - (1). new_id는 길이 1 이상 1,000 이하인 문자열입니다.
        // - (2). new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
        // - (3). new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
        // - 예측: 정규식을 이용해서 입력값을 필터링한다.


        // [2단계: 핵심 명사 및 동사 추출]
        // - 명사: new_id
        // - 동사: 소문자로 변경(toLowerCase), 문자 제거, 치환, 대입


        // [3단계: 지문 해체 및 기준 수립]
        // - 지문: new_id 를 주어진 7단계를 순차적으로 검증 후 리턴 값 추출
        // - 기준: 주어진 7단계가 핵심

        // [4단계: 요약 및 알고리즘]
        // 1단계: 대문자를 소문자로 치환 
        String answer = new_id.toLowerCase();
        
        
        // 2단계: 허용되지 않은 문자 제거
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3단계: 연속된 마침표(.)를 하나의 마침표로 치환
        answer = answer.replaceAll("\\.{2,}", ".");
        
        // 4단계: 처음이나 끝에 위치한 마침표(.) 제거
        answer = answer.replaceAll("^\\.|\\.$", "");
        
        // 5단계: 빈 문자열이라면 "a" 대입
        if (answer.isEmpty()) { answer = "a"; }
        
        // 6단계: 16자 이상이면 15자로 자르고 끝 마침표 제거
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("\\.$", "");
        }
        
        // 7단계: 길이가 2자 이하라면 마지막 문자를 반복해서 길이 3 맞추기
        while (answer.length() < 3) {
            answer += answer.charAt(answer.length () - 1);
        }

        // [5단계: 방어 논리 구축]
        // - 특수문자만 입력되거나 빈 문자열이 되는 예외 케이스를 5단계("a" 대입)와 7단계(길이 확장)
        return answer;
    }
}