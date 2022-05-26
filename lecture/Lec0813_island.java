package lecture;

import java.util.Scanner;

public class Lec0813_island {
    static int dx[]={-1,-1,0,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};
    static int n, answer=0;//섬의 개수

    public void DFS(int x, int y, int[][] board){
        for(int i=0; i<8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[y];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n
                    && board[nx][ny] == 1) { //섬이고 방문안한곳
                board[nx][ny] = 0;//바다로 변경
                DFS(nx, ny, board);
            }
        }
    }

    public void solution(int[][] board){
        //1(섬)방문한 곳 0으로 바꿈
        //다 0이면 return
        //다시 DFS호출하고 1(섬)만나면 answer++;
            for (int i=0; i<n; i++){
                for (int j=0; j<n; j++) {
                    if(board[i][j]==1){
                        answer++;//섬발견 ++
                        board[i][j]=0;//출발점
                        DFS(i, j, board);//대각선포함 동서남북 돈다
                    }
                }
            }
    }

    public static void main(String[] args) {
        Lec0813_island t = new Lec0813_island();
        Scanner kb = new Scanner(System.in);
        n= kb.nextInt();
        int[][] arr = new int[n][n];
//        ch = new int[n][n];
        for(int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.solution(arr);
        System.out.println(answer);
    }
}
