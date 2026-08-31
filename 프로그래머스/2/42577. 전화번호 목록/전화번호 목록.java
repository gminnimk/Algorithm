import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        // 1. 사전순으로 정렬 (접두어 관계를 가진 번호들이 서로 인접하게 배치)
        Arrays.sort(phone_book);
        
        // 2. 인접한 두 번호만 단일 루프로 비교
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        return true;
    }
}