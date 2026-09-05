import java.util.*;

class Solution{
    public String solution(String number, int k){
        
        // StringBuilder를 스택처럼 활용하여 O(N) 순회 최적화
        StringBuilder sb = new StringBuilder();
        int length = number.length();

        for (int i = 0; i < length; i++) {
            char c = number.charAt(i);

            // 스택의 마지막 문자가 현재 문자보다 작고 아직 제거할 수 있는 k가 남아있다면 제거
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(c);
        }

        // 만약 내림차순 정렬 형태여서 k가 남았다면 뒤쪽에서 k개 만큼 잘라냄
        return sb.substring(0, sb.length() - k);
    }
}