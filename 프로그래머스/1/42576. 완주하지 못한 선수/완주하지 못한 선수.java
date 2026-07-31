import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // [1단계: 제한사항 분석 및 예측]
        // (1-1). 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
        // => O(N^2) X
        
        // [2단계: 핵심 명사(변수/자료구조) 및 동사(연산/로직) 추출]
        // 명사:
        // - participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
        // - completion: 완주한 선수들의 이름이 담긴 배열
        
        // 동사:
        
        // [3단계: 지문 의도 해체]
        // 지문 의도: 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
        // => 배열의 값들을 비교 분석하여 남은 값을 return 처리
        
        // [4단계: 요약 및 알고리즘 파이프라인 확립]
        // 요약: 해시맵을 이용해 주어진 참가자 배열을 먼저 삽입 후 완주자 배열을 비교하여 차감하고 남은 key 값을 return 한다
        // 알고리즘 파이프라인: 해시맵
        
        // [5단계: 방어 논리 구축]
        // (5-1). 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 
        // => 대문자가 들어와도 소문자로 변형 인식하도록 세팅이 필요하지 않나?
        
        // (5-2). 참가자 중에는 동명이인이 있을 수 있습니다.
        // => 동명이인에 대한 중복 처리 필요
        // => 이거는 key,value 로 해결
        
        
        // [ 실제 코드 풀이 ]
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // 1. 참가자 배열을 먼저 해시맵에 삽입
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
        
        // 2. 완주자 배열을 참가자 배열에 빗대어 중복 (key, value) 발견 시 value 값 차감
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) -1);
        }
        
        // 맵에 남아있는 key, value 값 리턴
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;  
            }
        }
        
        return "";
    }
}