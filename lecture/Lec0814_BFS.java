package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0814_BFS {
    static int n, answer=0;
    static Queue<location> q = new LinkedList<>();
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};

    public void BFS(int x, int y, int[][] arr){
        //첫번째 위치 queue에 넣기
        q.offer(new location(x, y));
        while (!q.isEmpty()){
            location tmp=q.poll();
            for (int i=0; i<8; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(nx>=0 && nx<7 && ny>=0 && ny<7
                && arr[nx][ny]==1){
                    arr[nx][ny]=0;//바다로 변경
                    q.offer(new location(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] arr) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    answer++;//섬++
                    arr[i][j] = 0;
                    BFS(i, j, arr);
                }
            }
        }
    }


    public static void main(String[] args) {
        Lec0814_BFS t = new Lec0814_BFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[][] arr = new int[n][n];
        //1. 섬의 위치 저장
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.solution(arr);
        System.out.println(answer);

    }
}
