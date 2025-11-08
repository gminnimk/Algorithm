import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main t = new Main();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(t.solution(str));
        sc.close();
    }
    
    public String solution(String str) {
        // 바뀐 단어를 효율적으로 담기
        StringBuilder answer = new StringBuilder();
        
        for (char x : str.toCharArray()) {
            // 대문자 -> 소문자
            if (Character.isUpperCase(x)) {
                answer.append(Character.toLowerCase(x));
            }
            // 소문자 -> 대문자
            if (Character.isLowerCase(x)) {
                answer.append(Character.toUpperCase(x));
            }
        }
        
        return answer.toString();
    }
}