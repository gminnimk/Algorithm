import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // [문제 분석]
        // N 마리의 폰켓몬 중 N/2마리를
        // "폰켓몬은 종류에 따라 번호를 붙여 구분"
        // => key, value 관리
        
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
        // 최대한 많은 종류의 폰켓몬을 포함해 N/2 마리를 선택.
        // => 폰켓몬 종류 번호의 개수 return 
        
        // Ex) 폰켓몬 개수는 8마리인데 종류가 2(5)가지 라면 2(4) return
        
        // 문제 정리:
        // N 마리의 폰켓몬에서 N/2 마리의 폰켓몬을 선택하되 최대한 많은 종류를 가져오는 문제
        // (HashMap, Math.min) 이용 해서 풀이
        
        
        // [코드 흐름]
        // (1). "폰켓몬은 종류에 따라 번호를 붙여 구분": 해시맵 이관
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int mob : nums) {
            map.put(mob, map.getOrDefault(mob, 0) + 1);
        }
        
        // (2). 최대한 많은 종류의 폰켓몬을 포함해 N/2 마리를 선택
        int maxSelect = nums.length/2;
        int maxSpecies = map.size();
        
        return Math.min(maxSelect, maxSpecies);
    }
}