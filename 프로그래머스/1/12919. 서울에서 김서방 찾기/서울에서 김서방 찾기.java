import java.util.Arrays; // Arrays 클래스를 사용하기 위해 필요한 import 문 추가

class Solution {
    public String solution(String[] seoul) { 
        // seoul 배열에서 "Kim"이 위치한 인덱스를 찾아 해당 인덱스를 포함한 문자열을 반환하는 메소드
        
        return "김서방은 " + Arrays.asList(seoul).indexOf("Kim") + "에 있다";
        
        // Arrays.asList(seoul): seoul 배열을 리스트로 변환
        // .indexOf("Kim"): 리스트에서 "Kim"이 위치한 인덱스 찾아냄
        // "Kim Seo-bang is at " + ... + "": 문자열을 연결하여 최종 결과를 반환
    }
}