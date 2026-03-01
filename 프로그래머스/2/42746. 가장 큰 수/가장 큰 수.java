import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // [문제 분석]
        // 정수를 이어 붙여 만들 수 있는 가장 큰 수? 
        // 정수는 이어 붙이기가 안 되므로 문자 형태로 바꿔서 이어 붙이고 비교를 해봐야 함
        // 이후 제일 큰 수를 문자열로 바꾸어서 return 하는 로직이 필요
        
        
        // [제한 사항]
        // numbers의 길이는 1 이상 100,000 이하입니다: O(N^2) 아래의 시간 복잡도
        // numbers의 원소는 0 이상 1,000 이하입니다.
        // 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

        
        // [코드 흐름]
        // (1). 정수형태로는 이어 붙일 순 없으므로 문자열 배열을 생성해서 이어 붙이는 작업 필요
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // (2). 내림차순 정렬
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // (3). 정렬 후 맨 앞에 문자가 0이면 0을 반환
        if (strArr[0].equals("0")) { return "0"; } 
        
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }
        
        return String.valueOf(sb);
    }
}