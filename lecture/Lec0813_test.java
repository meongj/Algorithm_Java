package lecture;

import java.text.DateFormatSymbols;
import java.util.Scanner;

public class Lec0813_test {
    static int n, answer=0;
    static int[][] arr;
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};

    public void DFS(int x, int y){
        //2. 섬에서 다각도 방향으로 섬탐색 -> 바다로 변경
        for(int i=0; i<8; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            if(nx>=0 && nx<n && ny>=0 && ny<n
            && arr[nx][ny]==1){
                arr[nx][ny]=0;
                DFS(nx, ny);
            }
        }
    }

    public void solution(int[][] arr){
        // 1. 섬(1) 위치 찾기
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j]==1){
                    answer++;
                    DFS(i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0813_test t = new Lec0813_test();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        arr = new int[n][n];
        for (int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.solution(arr);
        System.out.println(answer);

    }
}
