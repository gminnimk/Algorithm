// [ Step 1: 제한사항 확인 및 역분석 => 알고리즘 압축 ]
// - numbers의 길이는 1 이상 100,000 이하입니다.
// - numbers의 원소는 0 이상 1,000 이하입니다.
// - 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.

// => O(N^2) 시간복잡도 초과, O(N logN) 까지 시간복잡도 허용 가능


// [ 문제 ]
// - 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수?

// - numbers: 0 또는 양의 정수가 담긴 배열
// - 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 return


// [ 요약 ]
// 0 또는 양의 정수가 담긴 배열 numbers를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 도출하는 문제


// [ 메모리 멘탈 모델 ]
// - 1. 정수 배열의 숫자를 수치 대소가 아닌 자릿수 기준 문자열 비교를 위해 String 배열로 변환한다.
// - 2. 데이터 규모가 10^5 이므로 모든 조합 생자는 불가능, 두 문자열을 서로 붙였을 때 어떤 순서가 더 큰지 비교((b + a).compareTo(a + b)하는 내림차순 정렬 전략을 취한다.
// - 3. 정렬된 배열의 첫 번째 원소가 '0'인 경우 이어 붙여도 0이므로 "0" return 처리

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 1. 숫자를 문자열로 변환할 String 배열 
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        
        // 2. 두 문자열을 이어 붙였을 때 더 큰 값이 앞으로 오도록 내림차순 커스텀 정렬
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        
        // 3. 예외 처리: 정렬 후 첫 번째 원소가 '0'이면 모든 원소가 0이라는 의미
        if (arr[0].equals("0")) {
            return "0";
        }
        
        // 4. SB 기반 정렬된 문자열 결합
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
    
        return sb.toString();
    }
}