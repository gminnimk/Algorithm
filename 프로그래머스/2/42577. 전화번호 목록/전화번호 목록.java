/*

# [ 제한사항 및 알고리즘 ]
- phone_book의 길이는 1 이상 1,000,000 이하입니다.
=> O(N^2) X / O(N logN) 까지 허용

-- 각 전화번호의 길이는 1 이상 20 이하입니다.
=> 1,000,000 * 20 => 20,000,000 => int형 O

-- 같은 전화번호가 중복해서 들어있지 않습니다.



# [ 문제 ]

- { phone_book }: 전화번호부에 적힌 전화번호를 담은 배열
- { 구해야 할 값 }: 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false / 그렇지 않으면 true return



# [ 메모리 멘탈 모델 ]

1. phone_book을 먼저 정렬처리 해준다.
=> 정렬 후 인접한 2개가 접두어인지 검사하기 매우 편해짐

2. phone_book[i + 1] 값이 phone_book[i]의 값의 접두어인지 루프문 내에서 판단 로직.
3. boolean 타입 반환


*/

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        
        // 1. 정렬 처리
        Arrays.sort(phone_book);
        
        // 2. 루프문 내에서 접두어 검증
        // => 정렬을 하였으므로 접두어가 존재한다면 붙어있는 2개의 값이 접두어 관계가 반드시 검증됨
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }
        
        // 루프문을 모두 검증하였는데 접두어가 없는 겨웅
        return true;
    }
}