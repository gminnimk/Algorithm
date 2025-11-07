import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) arr1[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) arr2[i] = Integer.parseInt(st.nextToken());

        int[] result = new int[n + m];

        int p1 = 0, p2 = 0, idx = 0;
        while (p1 < n && p2 < m) {
            if (arr1[p1] <= arr2[p2]) result[idx++] = arr1[p1++];
            else result[idx++] = arr2[p2++];
        }

        while (p1 < n) result[idx++] = arr1[p1++];
        while (p2 < m) result[idx++] = arr2[p2++];

        StringBuilder sb = new StringBuilder();
        for (int x : result) sb.append(x).append(' ');
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}