/*

# [ 제한사항 및 알고리즘 ]

- genres[i]는 고유번호가 i인 노래의 장르입니다.
- plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
- genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
=> worstCase는 10,000 * 10,000 이므로 O(N^2)는 리스크 / O(N logN) 까지 안전하게 허용

- 장르 종류는 100개 미만입니다.
- 장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
- 모든 장르는 재생된 횟수가 다릅니다.



# [ 문제 ]

- { genres }: 노래의 장르를 나타내는 문자열 배열
Ex) ["classic", "pop", "classic", "classic", "pop"]

- { plays }: 노래별 재생 횟수를 나타내는 정수 배열
Ex) [500, 600, 150, 800, 2500]

- { 구해야 할 값 }: 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
Ex) [4, 1, 3, 0]


- 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하고자 함
=> Map<장르, 재생 횟 수> 로 묶어서 장르별 재생 수 총합 계산 및 내림차순


- 노래는 고유 번호로 구분
=> genres[i]는 고유번호가 i인 노래의 장르입니다.
=> plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.


- { 노래를 수록하는 기준 }:

1. 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
=> 장르를 묶어서 재생 수 총합 기준 내림차순 (Map<String, Integer>)
=> 이후 2번으로 넘어갈려면 keySet 메서드를 이용해서 장르 추출 후 해당 장르의 노래 정보 (고유 번호와 재생 횟 수)를 넘김.

2. 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
=> 고유 번호(각 노래)별로 재생 횟 수 기준 내림차순 정렬

3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
=> 고유 번호 기준 오름차순 정렬

1번은 따로 Map 으로 선 처리 후 정렬을 진행하고,
2,3번을 묶어서 '노래' 를 재생 수와 고유 번호를 묶어서 객체로 관리하고 커스텀 정렬 수행



=> 입출력 예
(1). 장르별로 먼저 재생 수 총합 집계 후 가장 많이 재생된 장르에 대해 먼저 내림차순으로 2개의 노래를 가져옴.

(2). 이후 그 다음으로 많이 재생된 장르의 상위 2개 노래의 고유번호를 추출
(상위 반복문을 장르의 종류 수 만큼 반복하면서 내부 루프(장르 별 최대 2개까지))




# [ 메모리 멘탈 모델 ]

- { 구해야 할 값 }: 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return
Ex) [4, 1, 3, 0]

- { 베스트 앨범 }: 장르 별로 가장 많이 재생된 노래를 두 개씩 모아

1. '노래' (고유 번호, 재생 수) 객체 및 커스텀 정렬 구현(재생 수 내림차순, 고유번호 오름차순)
2. 장르별 가장 많이 재생된 수를 집계하기 위한 전용 맵 & 노래 객체를 저장 할 전용 맵 선언 및 처리
3. 장르별 가장 많이 재생된 수에 대한 맵에 대해 내림차순 및 keySet() 메서드 활용하여 장르 가져오기
4. 해당 장르의 노래 정보를 가져와서 '고유번호를 추출' 및 배열에 담아 return

*/
import java.util.*;

class Solution {
    
    // 1. '노래' (고유 번호, 재생 수) 객체 및 커스텀 정렬 구현(재생 수 내림차순, 고유번호 오름차순)
    static class Song implements Comparable<Song> {
        int id;
        int play;
        
        Song (int id, int play) {
            this.id = id;
            this.play = play;
        }
        
        @Override
        public int compareTo(Song o) {
            if (this.play != o.play) {
                return Integer.compare(o.play, this.play);
            }
            
            return Integer.compare(this.id, o.id);
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;
        
        // 2. playMap(장르 총합 누적) & songMap(장르별 Song 객체 리스트 computeIfAbsent) 채우기
        Map<String, Integer> playMap = new HashMap<>();
        Map<String, List<Song>> songMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            playMap.put(genres[i], playMap.getOrDefault(genres[i], 0) + plays[i]);
            songMap.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        // 3. playMap.keySet()을 ArrayList로 변환하여 총합 기준 내림차순 정렬
        List<String> sortedGenres = new ArrayList<>(playMap.keySet());
        sortedGenres.sort((a, b) -> Integer.compare(playMap.get(b), playMap.get(a)));

        // 4. sortedGenres 루프: Collections.sort(songs) 후 Math.min(songs.size(), 2) 곡 추출
        
        List<Integer> bestAlbum = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Song> songs = songMap.get(genre);
            Collections.sort(songs);
            
            int limit = Math.min(songs.size(), 2);
            for (int i = 0; i < limit; i++) {
                bestAlbum.add(songs.get(i).id);
            }
        }

        // 5. bestAlbum 리스트를 int[] 기본형 배열로 변환 후 반환
        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < bestAlbum.size(); i++) {
            answer[i] = bestAlbum.get(i);
        }
        
        return answer;
    }
}