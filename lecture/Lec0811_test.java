package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class location{
    int x, y;
    location(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Lec0811_test {
    static int arr[][];
    static int dis[][];
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};


    public void BFS(int x, int y){
        Queue<location>  q = new LinkedList<>();
        q.offer(new location(x, y));
        arr[x][y]=1;
        while (!q.isEmpty()){
            location tmp =q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];
                if(arr[nx][ny]==0 &&
                   nx >=1 && nx<=7 && ny>=1 && ny<=7){
                    arr[nx][ny]=1;
                    q.offer(new location(nx, ny));
                    dis[nx][ny]=arr[tmp.x][tmp.y]+1;
                }

            }
        }
    }

    public static void main(String[] args) {
        Lec0811_test t = new Lec0811_test();
        Scanner kb = new Scanner(System.in);
        arr = new int[8][8];
        dis = new int[8][8];

        for(int i=1; i<=7; i++){
            for (int j=1; j<=7; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.BFS(1,1);

        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
