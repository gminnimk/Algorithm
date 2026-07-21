import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        
        // [ 단계별 수립 ]
        
        // [1단계] : 제약 사항 분석 및 전략 예측
        // 무인도에 갇힌 사람은 1명 이상 50,000명 이하입니다.
        // => O(N^2) X / 완전탐색 불가
        // O(N) or O(N logN)
        
        // [2단계] : 핵심 명사(변수/알고리즘) 및 동사(제어/로직) 도출
        // 명사: 몸무게 배열(people), 구명보트 무게 제한(limit)), 포인터(heaviest & lightest)
        // 동사: 비교 (<=..), 포인터 이동, 추가 및 감소 (++, --), 정렬 (Arrays.sort), 합 (+)
        
        // [3단계] : 지문 의도 해체 및 핵심 기준 수립
        // 지문 의도: '무게 제한이 존재하는 최대 2명 탑승 가능한 보트'
        // 핵심 기준: 가장 몸무게가 큰 사람(heaviest)과 가장 작은 사람을 함께 보트에 태워서 최솟값 확보
        
        // [4단계] : 1~2줄 요약 및 알고리즘 파이프라인 확정
        // 1줄 요약: 몸무게를 정렬하여 투포인터 및 그리디를 사용해 주어진 무게값과 비교하여 보트의 개수를 구하는 문제
        // 알고리즘 파이프라인: 정렬 + 투 포인터 + 그리디
        
        // [5단계] : 방어 논리 구축 (엣지 케이스 및 예외 검증)
        // 사람을 보트에 태우는 과정(loop문)에서 무게 초과 여부에 따른 포인터 및 보트 조정
        
        
        // [ 코드 구현 ]
        // 1. 주어진 몸무게 정렬
        Arrays.sort(people);
        
        // 2. 보트 및 포인터 선언
        int boat = 0;
        int lightest = 0;
        int heaviest = people.length - 1;
        
        // 2. 사람들을 보트에 태우는 작업 (모든 사람들을 태울때 까지)
        while (lightest <= heaviest) {
            
            // 엣지 케이스 처리 : 1명만 남은 경우 (사람이 홀수인 경우)
            if (lightest == heaviest) {
                boat++;
                break;
            }
            
            if (people[heaviest] + people[lightest] <= limit) {
                lightest++;
            }
            
            heaviest--;
            boat++;
        }
        
        // 3. 최솟값 반환
        return boat;
    }
}