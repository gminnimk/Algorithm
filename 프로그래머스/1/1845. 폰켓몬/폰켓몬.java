import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // [문제 분석]
        // N 마리의 폰켓몬 중 N/2마리를 가져가야 함
        // 폰켓몬은 종류에 따라 번호를 붙여 구분, 같은 종류의 폰켓몬은 같은 번호를 갖고 있음
        // => 해시맵
        
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
        // 최대한 많은 종류의 폰켓몬을 포함해 N/2마리를 선택
        // 이때 폰켓몬 종류 번호의 개수를 return 
        
        
        // [코드 흐름]
        // 코드 전체의 시간 복잡도: O(N)
        // (1). 해시맵 선언 및 폰켓몬 배열 이관
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums 배열 반복 O(N) + O(1) = O(N)
        for (int mob : nums) {
            map.put(mob, map.getOrDefault(mob, 0) + 1);
        }
        
        // (2). 최대 선택 및 종류에 대한 변수 선언 및 Math 함수 사용
        int maxSelect = nums.length/2;
        int maxSpecies = map.size();
        
        // 종류가 N/2 수 보다 많다면 N/2 가 반환되게
        // 종류가 N/2 수 보다 작다면 종류가 반환되게
        return Math.min(maxSelect, maxSpecies);
    }
}