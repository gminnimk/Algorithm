import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        // [문제 분석]
        // 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수?
        
        // numbers: 0 또는 양의 정수가 담긴 배열
        // 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어 return
        
        // -명사: 배열
        // -동사: 순서를 재배치, 문자열로 변환
        // => 커스텀 정렬, String.valueOf()
        
        
        // [코드 흐름]
        // (1). 주어진 정수 배열을 문자 형태로 저장하기 위해서 문자 배열을 선언 및 배열 이관
        String[] strArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // (2). 문자열 형태로 전부 변환했으니 내림차순 커스텀 정렬이 필요
        // 문자를 이어 붙였을 때 조합 중 더 큰 값을 기준으로 정렬
        Arrays.sort(strArr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // (3). 만약 맨 앞 문자가 "0"일때?
        if (strArr[0].equals("0")) { return "0"; }
        
        // (4). 정렬을 완료했으니 배열에 담아 return
        // 단, 제한 사항에서 길이는 100,000 이하이므로 시간 초과 방지를 위해 append 사용
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }

        return String.valueOf(sb);
    }
}