package PG.Level1.stack;

import java.util.Stack;
//https://school.programmers.co.kr/learn/courses/30/lessons/64061
public class PG64061_크레인인형뽑기게임 {

    Stack<Integer> stack = new Stack<Integer>(); // 바구니
    int cnt = 0;

    public int solution(int[][] board, int[] moves) {

        for (int i = 0; i < moves.length; i++) {
            int col = moves[i]-1;// 열
            for (int j=0; j < board.length; j++) { //행
                if(board[j][col] != 0 ) {
                    moveBucket(board[j][col]);
                    board[j][col] = 0;
                    break; //찾으면 for문 종료
                }
            }
        }

        return cnt;
    }

    public void moveBucket(int x) {
        if(stack.isEmpty()) stack.push(x);
        else {
            if(stack.peek() == x) {
                cnt += 2;
                stack.pop();
            } else stack.push(x);
        }
    }

    public static void main(String[] args) {
        PG64061_크레인인형뽑기게임 t = new PG64061_크레인인형뽑기게임();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        t.solution(board, moves);
    }
}
