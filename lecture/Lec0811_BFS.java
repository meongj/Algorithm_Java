package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point0811{
    public int x, y;
    Point0811(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Lec0811_BFS {
    static int[][] arr, dis;
    static int[] dx= {-1, 0, 1, 0};
    static int[] dy= {0,1,0,-1};

    public void BFS(int x, int y){
        Queue<Point0811> Q = new LinkedList<>();
        Q.offer(new Point0811(x, y));
        arr[x][y]=1;
        while (!Q.isEmpty()){
            Point0811 tmp = Q.poll();
            for (int i=0; i<4; i++){
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if(nx>=1 && nx<=7 && ny>=7 && ny<=7
                        && arr[nx][ny]==0) {
                    arr[nx][ny]=1;
                    Q.offer(new Point0811(nx, ny));
                    dis[nx][ny] = dis[tmp.x][tmp.y]+1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0811_BFS t = new Lec0811_BFS();
        Scanner kb = new Scanner(System.in);
        arr = new int[8][8];
        dis = new int[8][8];

        for (int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                arr[i][j] = kb.nextInt();
            }
        }
        t.BFS(1,1);
        if(dis[7][7]==0) System.out.println(-1);
        else System.out.println(dis[7][7]);
    }
}
