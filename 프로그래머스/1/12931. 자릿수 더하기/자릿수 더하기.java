import java.util.*;

public class Solution {
    // 각 자리수의 합을 구하는 메소드 
    public int solution(int n) {
        int answer = 0;
        
        while(n>0) { //'while' 반복문을 사용하여 'n'이 0보다 클 때까지 반복. 이는 'n'이 0보다 클 때까지 각 자리수를 계산하고자 하는 것. 
            answer += n%10; // 'n'을 10으로 나눈 나머지를 'answer'에 더하기. 이렇게 하면 'n'의 일의 자리 숫자가 'answer'에 더해짐. 
            n = n/10; // 'n'을 10으로 나눈 몫을 새로운 'n'으로 갱신. 이렇게 하면 'n'의 일의 자리 숫자가 제거되고 십의 자리 숫자가 일의 자리로 이동. 
            }
        return answer;
    }
}