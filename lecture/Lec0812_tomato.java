package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class board{
    int x;
    int y;
    board(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Lec0812_tomato {
    static int m, n;
    static int[][] arr, dis; //arr : 체크배열 / dis: 최소일수 저장
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static Queue<board> q = new LinkedList<>();


    public void BFS(){

        while (!q.isEmpty()){
            board tmp = q.poll();
            for (int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m
                &&arr[nx][ny]==0){
                    arr[nx][ny]=1;
                    q.offer(new board(nx, ny));
                    dis[nx][ny]=dis[tmp.x][tmp.y]+1;//일자 누적
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0812_tomato t = new Lec0812_tomato();
        Scanner kb = new Scanner(System.in);
        m= kb.nextInt();
        n= kb.nextInt();
        arr= new int[n][m];
        dis = new int[n][m];

        // 1. 큐 돌기전 미리 1(익은 토마토) 위치들 저장함
        // 익은 토마토 근처로 동시다발적으로 퍼져나가기 위함
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr[i][j] = kb.nextInt();
                if(arr[i][j]==1) q.offer(new board(i,j));
            }
        }

        t.BFS();
        boolean flag=true;
        int answer = Integer.MIN_VALUE;//최소일자

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(arr[i][j]==0) flag=false;//익지 x경우 있으면
            }
        }
        if(flag){
            //모두 다 익었다면 최소일수 구하기
            for(int i=0; i<n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
        }
        else{
            answer=-1;
        }

        System.out.println(answer);


    }
}
