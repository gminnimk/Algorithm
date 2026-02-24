import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // [문제 분석]
        // 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수?
        // => 주어진 수에서 가장 큰 수가 앞으로 오게끔 정렬이 필요함
        
        // numbers: 0 또는 양의 정수가 담긴 배열
        
        // 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
        
        
        // [제한 사항]
        // numbers의 길이는 1 이상 100,000 이하입니다. : O(N logN) 까지 가능 O(N^2) 불가능
        
        // numbers의 원소는 0 이상 1,000 이하입니다. : O(N^2) 가능
        // => O(N(100,000) x L(1,000)): O(N^2) 불가능, 그 아래 시간 복잡도 사용 가능
        
        // 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
        // => String.valueOf 를 이용
        
        
        // [코드 흐름]
        // 코드 전체 시간 복잡도: O(N logN)
        // (1). 주어진 배열을 문자열 배열로 옮겨야 할 거 같음
        // => 각 정수들을 문자 형태로 바꿔서 배열에 추가
        // 루프: O(N)
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // (2). 전부 다 옮긴 후 내림차순 정렬
        // => 이 구간에서 각 문자열들을 조합하여 자동으로 내림차순으로 정렬하지 않나 싶음
        // 정렬: O(L * N logN)
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // (3). 정렬 후 맨 앞에 문자열이 0이면 0을 return 하도록 조건문 추가
        if (strArr[0].equals("0")) { return "0"; }
        
        // (4). 마지막 반환 전 문자열로 return 하도록 설정
        // 루프: O(N)
        StringBuilder sb = new StringBuilder();
        for (String number : strArr) {
            sb.append(number);
        }
        
        return sb.toString();
    }
}