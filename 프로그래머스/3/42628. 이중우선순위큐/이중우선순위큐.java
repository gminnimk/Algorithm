/*

# [ Step 1 : 제한사항 확인 및 역분석 => 알고리즘 압축 ]

- operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
=> O(N^2) 시간 복잡도 불가능
=> 주어진 배열의 길이만 놓고 봤을때는 O(N logN) 선형 로그 시간 까지가 최대 허용 시간 복잡도


- operations의 원소는 큐가 수행할 연산을 나타냅니다.
-- 원소는 “명령어 데이터” 형식으로 주어집니다. (Ex. ["I 16"])
=> 입력된 명령어 데이터에 따라 동작해야 하므로 split 처리

-- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
=> 하나만 삭제되므로 중복 허용 자료구조
=> 자료구조에서 최댓값/최솟값 두 경우 효율적인 처리 시간이 고려되어야 함
-- 이 경우 PQ를 선언하면 '최댓값' or '최솟값' 만 O(N) 으로 처리되므로 구현 불가능
-- 그렇다면 PQ를 2개 선언하여서 처리한다? 굉장히 복잡해질것으로 예상 (각 자료구조를 연산마다 계속 확인해야하고 비교해야하고 등)

-- 최종적으로 생각해볼 수 있는 방법으로는 자가 탐색 Red-Black 트리인 Tree 자료구조를 활용
-- 이떄 '중복 허용'을 고려해야 하므로 'TreeMap 자료구조'가 가장 적절하지 않을까?
-- Tree 자료구조의 경우 기본적으로 값에 대한 정렬이 보장되기에 최댓값/최솟값을 최적의 효율로 처리할 수 있는 장점이 존재


- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.


# [ Step 2 : 명사/동사 키워드 추출 ]
# [ Step 3 : 자료형 & 엣지케이스 검증 ]

- 빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
=> continue 처리


# [ 문제 ]

- 이중 우선순위 큐: 문제에서 주어진 연산을 수행하는 자료구조
- operations: '이중 우선순위 큐'가 할 연산 배열

- 구해야 할 값:
-- '이중 우선순위 큐'가 'operations'의 모든 연산을 처리한 후
-- 큐가 비어있으면 [0, 0] / 비어있지 않으면 [최댓값, 최솟값]을 return


# [ 메모리 멘탈 모델 ]

1. 최댓값/최솟값을 바로 찾아내기 위해서 정렬과 중복 처리가 보장되는 'TreeMap' 구축
2. operations 배열 연산을 수행하기 위한 반복문 및 split 함수를 사용해 각 순차 입력 데이터 인식 최적화
3. 명령어가 'I 숫자'/'D 1'/'D -1' 중에서 어떤 데이터가 들어왔는지에 대해 조건 분기 처리
=> 각 명령어에 올바른 업무 처리

4. 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 
=> return new int[]{0, 0}; / return new int[]{lastKey(), firstKey()};
*/

import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        
        // 1. 최댓값/최솟값을 바로 찾아내기 위해서 정렬과 중복 처리가 보장되는 'TreeMap' 구축
        TreeMap<Integer, Integer> map = new TreeMap<>(); // key, value (입력 데이터, 데이터 수)
        
        // 2. operations 배열 연산을 수행하기 위한 반복문 및 split 함수를 사용해 각 순차 입력 데이터 인식 최적화
        for (String oper : operations) {
            String[] part = oper.split(" ");
            String command = part[0];
            int num = Integer.valueOf(part[1]);
    
            
            // 3. 명령어가 'I 숫자'/'D 1'/'D -1' 중에서 어떤 데이터가 들어왔는지에 대해 조건 분기 처리
            // => 각 명령어에 올바른 업무 처리
            
            // 3-1. 'I 숫자'인 경우
            if (command.equals("I")) {
                // 큐에 주어진 숫자 삽입
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            
            // 3-2. 'D 1 or -1'인 경우 (삭제 연산)
            else if (command.equals("D")) {
                
                // '빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시'
                if (map.isEmpty()) { continue; }
            
                // 큐에 최댓값 삭제
                if (num == 1) { // 명령어가 1이면서 해당 큐에 값이 존재
                    map.put(map.lastKey(), map.get(map.lastKey()) - 1);
                    
                    // value 가 0이라면 그냥 map에서 제거
                    if (map.get(map.lastKey()) == 0) {
                        map.remove(map.lastKey());
                    }
                }
                
                // // 큐에 최솟값 삭제
                if (num == -1) {
                    map.put(map.firstKey(), map.get(map.firstKey()) - 1);
                
                    if (map.get(map.firstKey()) == 0) {
                        map.remove(map.firstKey());
                    }
                }
            }
        }
    
        // 4. 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 
        // => return new int[]{0, 0}; / return new int[]{lastKey(), firstKey()};
        
        // 4-1. 큐가 비어있는 경우 처리
        // @@@@ map 안에 값 체크 여부 어떻게 하더라
        if (map.isEmpty()) { 
            return new int[]{0,0};
        }
        
        // 4-2. 큐가 비어있지 않은 경우 처리
        return new int[]{map.lastKey(), map.firstKey()};
    }
}