package lecture;

import java.util.Scanner;

public class Lec0810_Maze {
    static int[][] maze;
    static int dx[]={-1,0,1,0};
    static int dy[]={0,1,0,-1};
    static int cnt=0;

    public void DFS(int x, int y){
        if(x==7 && y==7){
            cnt++;
            return;
        }else{
            for (int i=0; i<4; i++){
                int nx =x + dx[i];
                int ny =y + dy[i];
                if(nx>=1 && nx<=7 && ny>=1 && ny<=7
                        && maze[nx][ny]==0){
                    maze[nx][ny]=1;//방문했다고 표시
                    DFS(nx, ny);
                    maze[nx][ny]=0;//뒤로백, 다시 탐색위함
                }

            }
        }
    }

    public static void main(String[] args) {
        Lec0810_Maze t = new Lec0810_Maze();
        Scanner kb = new Scanner(System.in);
        maze = new int[8][8];
        for(int i=1; i<=7; i++){
            for(int j=1; j<=7; j++){
                maze[i][j] = kb.nextInt();
            }
        }
        maze[1][1]=1;
        t.DFS(1,1);
        System.out.println(cnt);
    }
}
