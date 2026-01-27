import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] strArr = new String[numbers.length];
        // 문자 형태로 모두 삽입
        // ex) ["6", "10", "2" ]
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // 이제 정렬을 통해서 문자열의 조합을 만들고 내림차순 진행
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // 예외 로직
        if (strArr[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            sb.append(strArr[i]);
        }
        
        return sb.toString();
    }
}