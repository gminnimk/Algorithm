class Solution {
    public int solution(String s) {
        /*
        입력으로 받은 문자열 s를 정수로 변환하여 반환. 
        Integer.parseInt() 메소드는 문자열을 정수로 변환하는 데 사용. 
        이 메소드는 문자열이 숫자로 이루어져 있을 경우 해당 숫자로 변환하고, 
        숫자가 아닌 문자가 포함되어 있을 경우 NumberFormatException을 발생시킴.
        */            
        return Integer.parseInt(s);
    }
}