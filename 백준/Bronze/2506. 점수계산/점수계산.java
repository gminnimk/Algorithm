import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 문제의 개수 n 이 주어짐
        int[] result = new int[n]; // n개 문제의 채점 결과가 담기는 배열
        for (int i = 0; i < n; i++) {
            result[i] = sc.nextInt();
        }
        
        System.out.print(T.solution(n, result));
        sc.close();
    }
    
    public int solution(int n, int[] result) {
        int totalScore = 0; // 반환 할 총합 점수 변수
        int cnt = 0; // 가산점을 더해 줄 변수
        
        for (int i = 0; i < n; i++) {
            if (result[i] == 1) {
                cnt++;
                totalScore += cnt;
            } else {
                cnt = 0;
            }
        }
        
        return totalScore;
    }
}