class Solution {
    public String solution(String my_string) {
        String answer = "";
        
        String reversedWord = new StringBuilder(my_string).reverse().toString();
        answer = reversedWord;
        
        return answer;
    }
}