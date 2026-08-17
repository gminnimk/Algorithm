// [ Step 1: 제한사항 분석 => 역분석 => 알고리즘 압축]
// - 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하
// => 최대 허용 시간 복잡도 O(N logN) / PQ ~ 정렬 알고리즘 예측 가능

// - completion의 길이는 participant의 길이보다 1 작습니다.
// - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
// => 정규식 사용

// - 참가자 중에는 동명이인이 있을 수 있습니다.
// => key, value 로 중복 처리 HashMap 유력


// [ Step 2: 명사/동사 키워드 추출 ]
// - 명사: 참가자, 완주자, 이름
// - 동사: 추가하다(put), 없으면 기본값으로 설정하다(getOrDefault)


// [ Step 3: 자료형 & 엣지케이스 검증 ]
// - 완주자 배열 길이는 참가자 배열 길이보다 항상 1이 작도록 설정되어 있음 
// - 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
// => 만약 문제에서 입력값에 대한 요구가 필요했다면 replaceAll, toLowerCase 로 강제 설정 필요 


// [ 요약 ]
// - HashMap을 이용해(key,value 구조로 동명이인 처리) 참가자 배열을 먼저 넣고 뒤이어 완주자 배열에서 중복된 key에 따라 value 값 차감 및 남은 key 값 출력 


// [ 문제 ]
// 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
// 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

// - participant: 마라톤에 참여한 선수들의 이름이 담긴 배열
// - completion: 완주한 선수들의 이름이 담긴 배열


// [ 풀이 ]
import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        // 1. HashMap 선언 및 참가자 배열 삽입
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String people : participant) {
            // map에 해당 값이 0이라면 +1 추가
            map.put(people, map.getOrDefault(people, 0) + 1);
        }
        
        // 2. 참가자 배열에서 완주자 배열 값 차감
        for (String people : completion) {
            // map에 해당 값이 존재한다면 -1 차감
            map.put(people, map.getOrDefault(people, 0) - 1);
        }
        
        // 3. 이후 남은 key 값(완주하지 못 한 단 한명의 완주자) 가져오기
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key; 
            }
        }
        
        return "";
    }
}