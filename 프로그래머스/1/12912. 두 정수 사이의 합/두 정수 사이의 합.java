class Solution {
    public long solution(int a, int b) {
        
        long answer = 0; // 합을 저장할 변수 초기화
    
        if(a < b){
            // a가 b보다 작을 때, a부터 b까지의 모든 정수를 더함
            for(int i = a; i <= b; i++){
                answer += i; // 현재 정수 i를 answer에 더함
            }
        } else if(a > b){
            // a가 b보다 클 때, b부터 a까지의 모든 정수를 더함
            for(int i = b; i <= a; i++){
                answer += i; // 현재 정수 i를 answer에 더함
            }
        } else {
            // a와 b가 같을 때, answer에 a(또는 b)를 저장
            answer = a; // a와 b가 같으므로 answer에 a를 저장
        }
    
        return answer; // 최종 합계 반환
    }
}
