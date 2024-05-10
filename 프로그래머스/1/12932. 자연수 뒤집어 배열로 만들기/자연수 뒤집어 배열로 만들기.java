class Solution {
    public int[] solution(long n) {
        String a = "" + n; // String a = "" + n;: long 타입의 정수 n을 문자열로 변환하여 a에 저장. n의 길이를 구할 수 있음. 
        
        
        // answer 배열을 선언하고, 길이를 a의 길이와 같게 설정. 이 배열은 n의 각 자리의 숫자를 담을 공간으로 사용됩니다.
        int[] answer = new int[a.length()];
        
        
        // 배열의 인덱스를 나타내는 변수 cnt를 선언하고 초기값을 0으로 설정
        int cnt = 0;
        
        
        // n이 0보다 클 때 무한루프 시작. 
        while(n > 0) {
            
            //n을 10으로 나눈 나머지를 배열 answer의 현재 인덱스에 저장합니다. n의 일의 자리 숫자가 answer 배열에 저장. 나머지 연산을 수행한 결과는 정수형으로 형변환하여 저장
            answer[cnt]=(int)(n%10);

            
            // n을 10으로 나눈 몫을 구하여 n에 다시 저장 , n의 일의 자리 숫자가 제거되고 다음 자리 숫자가 일의 자리로 이동
            n/=10;
            cnt++; // 배열의 다음 인덱스로 이동하기 위해 cnt를 증가! 
            
        }
        return answer;
    }
}