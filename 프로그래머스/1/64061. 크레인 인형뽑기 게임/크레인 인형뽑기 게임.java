import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution T = new Solution();
        Scanner sc = new Scanner(System.in);
        
        // board = 인형들을 담은 2차원 배열
        int n = sc.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                board[i][j] = sc.nextInt();
            }
        }
        
        // moves = 크레인 동작 위치를 담은 배열
        int m = sc.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++){
            moves[i] = sc.nextInt();
        }
        
        System.out.print(T.solution(board, moves));
    }
    
    public int solution(int[][] board, int[] moves){
        int answer = 0;
        Stack<Integer> bucket = new Stack<>();
        
        // 크레인 열 동작
        for (int move : moves){
            
            int col = move - 1; // 실제 동작 열
            
            // 크레인이 위치 한 해당 열에서 행을 0에서 부터 4까지 탐색 
            for (int row = 0; row < board.length; row++){ 
                // board[][] 에 인형이 존재한다면 꺼내서 바구니에 담고 
                if (board[row][col] != 0){
                    int doll = board[row][col]; // 인형 저장
                    board[row][col] = 0; // 해당 위치 인형 제거
                    
                    // 바구니가 비어있거나 동일하지 않은 인형이 있다면 저장
                    if (bucket.isEmpty() || doll != bucket.peek()){
                        bucket.push(doll);
                    } else {
                        bucket.pop();
                        answer += 2;
                    }
                    break;
                }
            }
        }
        return answer;
    }
}