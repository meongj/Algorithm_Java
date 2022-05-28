package BOJ.DFS;

import java.util.Scanner;

public class Boj10026_RedGreen {
    static int n, not_normal=0, normal=0;
    static char[][] arr;
    static boolean[][] normal_visit, not_normal_visit;
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};


    public void DFS_NORMAL(int x, int y){
        normal_visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx<n && ny>=0 && ny<n
            && !normal_visit[nx][ny]){
                if(arr[x][y]==arr[nx][ny]){
                    DFS_NORMAL(nx, ny);
                }
            }
        }
    }

    public void DFS_NOY_NORMAL(int x, int y){
        not_normal_visit[x][y] = true;
        for(int i=0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx >=0 && nx<n && ny>=0 && ny<n
                    && !not_normal_visit[nx][ny]){
                if((arr[x][y]=='R' && arr[nx][ny]=='G')
                 || (arr[x][y]=='G' && arr[nx][ny]=='R')
                 || (arr[x][y]==arr[nx][ny])){
                    DFS_NOY_NORMAL(nx, ny);
                }
            }
        }
    }

    public void solution(char[][] arr){
        for (int i=0; i<n ; i++) {
            for (int j = 0; j < n; j++) {
                if(!normal_visit[i][j]) {
                    normal++;
                    DFS_NORMAL(i, j);
                }
            }
        }
        for (int i=0; i<n ; i++) {
            for (int j = 0; j < n; j++) {
                if(!not_normal_visit[i][j]) {
                    not_normal++;
                    DFS_NOY_NORMAL(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Boj10026_RedGreen t = new Boj10026_RedGreen();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new char[n][n];
        normal_visit = new boolean[n][n];
        not_normal_visit = new boolean[n][n];

        for (int i=0; i<n ; i++){
            String input = kb.next();
            for(int j=0; j<n; j++){
                arr[i][j] = input.charAt(j);
            }
        }
        t.solution(arr);

        System.out.println(normal+" "+not_normal);


    }
}
