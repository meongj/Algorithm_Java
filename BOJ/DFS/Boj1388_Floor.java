package BOJ.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Boj1388_Floor {
    static class Location{
        int x, y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int n, m, answer=0;
    static char[][] arr;
    static int[] dx={0,0,1,-1};
    static int[] dy={1,-1,0,0};
    static boolean[][] visit;
    static Queue<Location> q;

    public void BFS(Location location){
        q.offer(location);
        visit[location.x][location.y] = true;

        while (!q.isEmpty()){
            Location tmp = q.poll();
            for(int i=0; i<4; i++){
                int nx = tmp.x+dx[i];
                int ny = tmp.y+dy[i];

                if(nx>=0 && nx<n && ny>=0 && ny<m){
                    if(arr[tmp.x][tmp.y] == '-') { //양 옆
                        if (arr[tmp.x][tmp.y] == arr[tmp.x][ny] // - 로 같고
                                && !visit[tmp.x][ny]){ // 방문안한곳이라면
                            visit[tmp.x][tmp.y] = true; //방문했음
                            q.offer(new Location(tmp.x, ny));
                        }
                    }else if(arr[tmp.x][tmp.y] == '|') { // 위 아래
                        if (arr[tmp.x][tmp.y] == arr[nx][tmp.y]
                                && !visit[nx][tmp.y]){
                            visit[tmp.x][tmp.y] = true;
                            q.offer(new Location(nx, tmp.y));
                        }
                    }
                }
            }
        }
    }

    public void solution(char[][] arr){
        for(int i=0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visit[i][j]) {
                    BFS(new Location(i, j));
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Boj1388_Floor t = new Boj1388_Floor();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        visit = new boolean[n][m];
        q = new LinkedList<>();
        arr=new char[n][m];

        for(int i=0; i<n; i++) {
            String input = kb.next();
            for (int j = 0; j < m; j++) {
                arr[i][j]= input.charAt(j);
            }
        }
        t.solution(arr);
        System.out.print(answer);


    }
}
