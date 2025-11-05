import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        // --- 투 포인터 알고리즘 ---
        int p1 = 0, p2 = 0;
        
        // 3. 두 배열을 비교하며 StringBuilder에 추가
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                sb.append(a[p1++]).append(" ");
            } else {
                sb.append(b[p2++]).append(" ");
            }
        }
        
        // 4. a 배열에 남은 원소 추가
        while (p1 < n) {
            sb.append(a[p1++]).append(" ");
        }
        
        // 5. b 배열에 남은 원소 추가
        while (p2 < m) {
            sb.append(b[p2++]).append(" ");
        }

        System.out.println(sb.toString());
        
        br.close();
    }
}