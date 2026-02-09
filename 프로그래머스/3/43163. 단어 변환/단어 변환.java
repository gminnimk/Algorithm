import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {

        // [문제 분석]
        // begin: 시작 단어
        // target: 목표 단어
        // words: 단어의 집합
        // '가장 짤읍 변환 과정': BFS
        
        
        // [규칙]
        // 1. 한 번에 한 개의 알파벳만 바꿀 수 있음: 인접 노드
        // 2. words에 있는 단어로만 변환할 수 있음: boolean[] 으로 체크 필요
        
        // 시작 단어와 words에 있는 단어를 비교하여 알파벳 하나만 다른 단어를 찾은 후 queue 에 삽입하고
        // 이 과정을 반복해서 target 단어를 찾으면 return 한다
        return bfs(begin, target, words);
    }
    
    class Node {
        String word;
        int count; // 몇번째?
        
        Node (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    private int bfs(String begin, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(begin, 0));
        boolean[] visited = new boolean[words.length];
        
        // queue가 전부 빌 때 까지 반복
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // 목표 단어를 찾으면
            if (current.word.equals(target)) { return current.count; }
            
            // 그게 아니라면 words 배열과 비교하면서 탐색 작업
            for (int i = 0; i < words.length; i++) {
                // (1). 방문한 적이 없고, (2). 한 번에 한 개의 알파벳만 바꿀 수 있는지 (인접 노드 단어가 알파벳 하나만 다른지)
                if (visited[i] != true && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], current.count + 1));
                }
            }
        }
        
        // 변환할 수 없는 경우 0을 return
        return 0;
    }
    
    private boolean canConvert(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != s1.charAt(i)) { diff++; }
        }
        
        return diff == 1;
    }
}