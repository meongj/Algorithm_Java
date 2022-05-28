package BOJ.DFS;

import java.util.Scanner;

public class Boj3187_Shepherd {

    static int R, C;
    static char[][] arr;
    static int sheep=0, walf=0, s, w;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visit;


    public void DFS(int x, int y){
        visit[x][y]=true;//방문
        if(arr[x][y]=='v') w++;
        else if(arr[x][y]=='k') s++;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx>=0 && nx<R && ny>=0 && ny<C
            && arr[nx][ny]!='#' && !visit[nx][ny]){
                    DFS(nx, ny);
            }
        }
    }

    public void solution(char[][] arr) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] != '#' && !visit[i][j]){ //늑대
                    s=0; w=0;
                    DFS(i, j);
                    if(s > w){ //양이 더 많으면
                        walf-=w;
                    }else if(w >= s){ // 늑대가 더 많으면
                        sheep-=s;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Boj3187_Shepherd t = new Boj3187_Shepherd();
        Scanner kb = new Scanner(System.in);
        R = kb.nextInt();
        C = kb.nextInt();
        visit = new boolean[R][C];
        arr = new char[R][C];

        for(int i=0; i<R; i++){
            String input= kb.next();
            for(int j=0; j<C; j++){
                arr[i][j] = input.charAt(j);
                if(arr[i][j]=='v') walf++;
                else if(arr[i][j]=='k') sheep++;
            }
        }
        t.solution(arr);
        System.out.print(sheep+" "+walf);

    }
}
