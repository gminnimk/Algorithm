import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // [문제 분석]
        // N 마리의 폰켓몬 중 N/2 마리를 가져가야 함
        // int maxSelect = nums.length/2;
        
        // 폰켓몬 종류에 따라 번호를 붙여 구문 => 같은 종류의 폰켓몬은 같은 번호를 갖고 있음
        // HashMap
        
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
        // 가장 많은 종류의 폰켓몬을 선택하는 방법?
        // 예를 들어 6마리가 주어졌으면 
        // int maxSelect = nums.length/2; == 3;
        // 근데 최대 종류가 2종류라면
        // int maxSpecies = map.size();
    
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int mob : nums) {
            map.put(mob, map.getOrDefault(mob, 0) + 1);
        }
        
        int maxSelect = nums.length/2;
        int maxSpecies = map.size();
        
        return Math.min(maxSelect, maxSpecies);
    }
}