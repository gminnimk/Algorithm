import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // [문제 분석]
        // N마리의 폰켓몬 중 N/2마리를 가져가도 된다고 함
        
        // 폰켓몬은 종류에 따라 번호를 구분하며 같은 종류의 폰켓몬은 같은 번호를 가지고 있음
        // => (종류 = key, 수 = value) | 해시맵
        // <Integer, Integer>
    
        // nums: N마리 폰켓몬의 종류 번호가 담긴 배열
    
        // 최대한 많은 종류의 폰켓몬을 포함해 N/2마리를 선택해야 함
        // 폰켓몬 종류 번호의 개수를 return
        // => map.size()
        
        // [제한 사항]
        // 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return
        // => 종류 최대값이 중복된다고 해도 하나만 출 
        
        // [코드 흐름]
        // (1). 해시맵 선언 및 폰켓몬 종류 번호 배열 이관
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int mob : nums) {
            map.put(mob, map.getOrDefault(mob, 0) + 1);
        }
        
        // (2). 최대한 많은 종류의 폰켓몬을 포함해 N/2 마리를 선택한다
        // => 종류 | N/2 마리에 대한 변수를 따로 지정하고
        // => Math.min 을 이용해 값을 return 한다
        // 예를 들어, 6마리에서 4종류의 폰켓몬이 있다고 하면 우리는 3마리를 선택해야하고 최대 3종류 까지만 선택이 가능하므로 종류보다 작은 선택값이 return 되어야 하기 때문
        // 그 반대로, 종류가 2마리 이고 선택이 3마리 이므로 min 덕분에 종류 2 값을 return
        
        int maxSpecies = map.size(); // 종류
        int maxSelect = nums.length/2; // 선택   
         
        return Math.min(maxSpecies, maxSelect);
    }
}