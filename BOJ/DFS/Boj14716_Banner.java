package BOJ.DFS;

import java.util.Scanner;

public class Boj14716_Banner {
    static int m, n, answer=0;
    static int[][] arr;
    static int[] dx={-1,-1,0,1,1,1,0,-1};
    static int[] dy={0,1,1,1,0,-1,-1,-1};


    public void DFS(int x, int y){
            for(int i=0; i<8; i++){
                //동서남북,대각선 숫자가 있는지 찾는다
                int nx= x+dx[i];
                int ny= y+dy[i];
                if(nx>=0 && nx<m && ny>=0 && ny<n
                && arr[nx][ny]==1){
                    arr[nx][ny]=0;
                    DFS(nx, ny);
                }
            }
    }

    public void solution(int[][] arr){
        for(int i=0; i<m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){//글자찾으면
                    answer++;
                    DFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Boj14716_Banner t = new Boj14716_Banner();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        arr = new int[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.solution(arr);
        System.out.println(answer);

    }
}
