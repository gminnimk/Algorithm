import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 1. 숫자를 문자열로 반환하여 배열에 담기
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 커스텀 정렬: (b+a)와 (a+b)를 비교하여 내림차순 정렬
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });
        
        if (strNumbers[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for (String s : strNumbers) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}