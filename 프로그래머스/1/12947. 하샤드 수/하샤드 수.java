class Solution {
    public boolean solution(int x) {
        boolean answer = true; // 초기 정답을 true로 설정
        int sum = 0; // 자릿수 합을 저장할 변수 초기화
        
        // 숫자를 문자열로 변환하고 각 자릿수를 배열에 저장
        String[] num = Integer.toString(x).split("");
        
        // 각 자릿수를 순회하며 자릿수 합 계산
        for(int i = 0; i < num.length; i++) {
            sum += Integer.parseInt(num[i]); // 문자열로 된 자릿수를 정수로 변환하여 합산
        }
        
        // 원래 숫자가 자릿수 합으로 나누어 떨어지지 않으면 false로 설정
        if(x % sum != 0)
            answer = false;
        
        return answer; // 결과 반환
    }
}
