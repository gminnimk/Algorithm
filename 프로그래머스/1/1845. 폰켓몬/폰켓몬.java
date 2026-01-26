import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        // N 마리의 폰켓몬 중 N/2 마리를 가져가도 됨
        // N/2 마리의 폰켓몬 중 최대한 다양한 종류의 값을 가지길 원함
        
        // 최대로 가질 수 있는 종류는 결국 N/2 개수
        int maxCnt = nums.length/2;
        
        // 1. 먼저 key, value 형태로 저장
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int mob : nums) {
            hm.put(mob, hm.getOrDefault(mob, 0) + 1);
        }
        
        // 2. 여기서 중요한 건 종류 (size())
        int speCnt = hm.size();
        
        
        // 3. 현재 저장된 종류와 최대로 가질 수 있는 종류 중 최소값 선택
        // (3-1.) 만약 저장된 종류가 최대로 가질 수 있는 종류를 넘어버리면 maxCnt 선택
        // (3-2.) 반대로 저장된 종류가 더 작으면 speCnt 선택
        return Math.min(maxCnt, speCnt);
    }
}