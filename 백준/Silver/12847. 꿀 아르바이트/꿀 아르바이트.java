import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Main t = new Main();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] Ti = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            Ti[i] = Integer.parseInt(st.nextToken());
        }
        
        System.out.print(t.solution(n, m, Ti)); 
        br.close();
    }
    
    public long solution(int n, int m, int[] Ti) {
        long sum = 0; // 갱신 할 합 변수
        
        // 초기 m일 동안의 최대 이익 값 설정
        for (int i = 0; i < m; i++) {
            sum += Ti[i];
        }
        
        long max = sum; // 최대 이익을 반환 할 변수
        
        // 슬라이딩 알고리즘
        for (int j = m; j < n; j++) {
            sum += Ti[j];
            sum -= Ti[j - m];
            
            max = Math.max(max, sum);
        }
        
        return max;
    }
}