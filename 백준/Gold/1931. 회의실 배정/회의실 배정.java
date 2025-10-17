import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        
        // n개의 회의
        int n = sc.nextInt();
        
        // n+1 줄까지 각 회의의 정보를 담는 배열 (시작, 끝)
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            meetings[i] = new Meeting(start, end); // 생성자 주입
        }
        System.out.print(T.solution(n, meetings));
    }
    
    // 최대 사용할 수 있는 회의의 최대 개수
    // => 탐욕 알고리즘을 사용
    public int solution(int n, Meeting[] meetings){
        Arrays.sort(meetings); // 회의 정보 정렬
        
        int count = 0;
        int prevEndTime = 0; // 이전 종료 시간 저장
            
        // 사용할 수 있는 회의 최대 개수
        // 회의 정보 탐색
        for(Meeting m : meetings){
            if(m.start >= prevEndTime){
                count += 1;
                prevEndTime = m.end; // 이전 종료 시간에 선택된 회의 종료 시간을 저장
            }
        }
        return count;
    }
    
    // 회의의 정보를 객체 형태로 생성 및 관리
    static class Meeting implements Comparable<Meeting> {
        public int start = 0;
        public int end = 0;
        
        public Meeting(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        // 다른 회의 정보와 비교하여 정렬하기 위한 메서드
        @Override
        public int compareTo(Meeting other){
            if (this.end != other.end){
                // this.end 로 오름차순 정렬
                return this.end - other.end;
            } else {
                // 끝나는 시간이 같다면 시작시간으로 오름차순 정렬
                return this.start - other.start;
            }
        }
    }
}