import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        Point[] arr = new Point[n]; // Point 클래스 타입으로 배열 선언

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(); // x좌표
            int y = sc.nextInt(); // y좌표
            arr[i] = new Point(x, y);
        }

        Arrays.sort(arr); // 정렬 실행 (Point의 compareTo에 따라 정렬됨)

        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }

        sc.close();
    }
}

// 좌표를 x좌표가 증가하는 순으로, x좌표가 같으면 y좌표가 증가하는 순서로 정렬하기 위한 클래스
class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 정렬 메서드 오버라이딩
    @Override
    public int compareTo(Point o) {
        if (this.x == o.x) { 
            // x값이 같을 경우 -> y값 기준으로 오름차순 정렬
            return this.y - o.y;
        } else { 
            // x값이 다를 경우 -> x값 기준으로 오름차순 정렬
            return this.x - o.x;
        }
    }
}