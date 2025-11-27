class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        // 입력된 도시이름 배열을 순서대로 처리할 때, "총 실행시간"을 출력한다.
        // cache hit일 경우 실행시간은 1이다.
        // cache miss일 경우 실행시간은 5이다.
        int answer = 0;
        String[] cache = new String[cacheSize]; // 캐시 배열
        
        // LRU 기법
        for (String x : cities) {
            int pos = -1; // 캐시 판가름
            x = x.toLowerCase();
            
            // 1. 배열에 캐시가 있는지 없는지
            for (int i = 0; i < cacheSize; i++) {
                if (x.equals(cache[i])) {
                    pos = i; // 캐시가 있다면 pos에 인덱스 저장
                    break;
                }
            }
            
            // 2. 밀어내기
            // (2-1. 캐시가 없고 새로운 값일떄 (miss)) 
            if (pos == -1) {
                answer += 5;
                for (int i = cacheSize - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1]; // 한 칸씩 뒤로밀기
                }
            } else { // (2-2. 캐시가 존재 (hit))
                answer += 1;
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            
            cache[0] = x;
        }
        return answer;
    }
}