import java.util.HashMap;

class Solution {
    public int solution(int[] nums) {
        
        // [문제 분석]
        // N 마리의 폰켓몬 중 N/2 마리를 가져가도 됨
        // 폰켓몬은 종류에 따라 번호를 붙여 구분: key, value => map
        
        // 최대한 많은 종류의 폰켓몬을 포함하여 N/2마리를 선택하려 함
        // 폰켓몬 종류 번호의 개수를 return
        // => map.size()
        
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
        
        // (1). 해시 맵 선언 및 nums 이관
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int mob : nums) {
            map.put(mob, map.getOrDefault(mob, 0) + 1);
        }
        
        // (2). 최대한 많은 종류를 포함해서 N/2 마리를 꺼내야 함
        // Ex) nums에 6마리 및 2 종류의 폰켓몬이 존재하지만 N/2 = 3
        // 그러나 최대 종류는 2 이므로 return 값은 2가 되어야 함
        // 만약 종류가 선택의 개수 제한보다 많다고 해도 Math.min으로 return 을 조절
        // Math.min(maxSpecies(2), maxSelect(3));
        int maxSelect = nums.length/2;
        int maxSpecies = map.size();
        
        return Math.min(maxSpecies, maxSelect);
    }
}