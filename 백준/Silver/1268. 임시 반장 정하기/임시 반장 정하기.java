import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 반 학생 수
        int[][] students = new int[n][5]; // 학생마다 1 ~ 5 학년
        for (int i = 0; i < n; i++) { // 각 학생 학년별 속해있는 표 입력
            for (int j = 0; j < 5; j++) {
                students[i][j] = sc.nextInt();
            }
        }
        
        System.out.print(T.solution(n, students));
        sc.close();
    }
    
    // 임시반장 반환 메서드
    public int solution(int n, int[][] students) {
        int maxCount = 0; // 최대 카운트 변수
        int president = 1; // 임시반장 변수, 1로 초기화
        
        for (int i = 0; i < n; i++) { // [i] 번 학생
            
            int currentCount = 0;
            
            for (int j = 0; j < n; j++) { // [j] 번 학생
                for (int k = 0; k < 5; k++) { //[k] 학년 (1 ~ 5)
                    
                    // 학생이 같으면 건너뛰기
                    if (i == j) {
                        continue;
                    }
                    
                    if (students[i][k] == students[j][k]) {
                        currentCount++;
                        break; // 학년이 하나라도 같으면
                    }
                }
            }
            
            if (currentCount > maxCount) {
                maxCount = currentCount;
                
                president = i + 1;
            }
        }
        
        return president;
    }
}