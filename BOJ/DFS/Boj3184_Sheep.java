package BOJ.DFS;

import java.util.Scanner;

public class Boj3184_Sheep {

    static int r, c;
    static char[][] arr;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int sheep=0, wolf=0; // 같은 양역 양수, 늑대수
    static int sheeps=0, wolves=0; // 전체 양수, 늑대수

    public void dfs(int x, int y) {
        //방문 체크
        visit[x][y]=true;
        //양수, 늑대수 세기
        if(arr[x][y] == 'o') sheep++;
        else if(arr[x][y] == 'v') wolf++;

        for (int i=0; i<4; i++) {
            //다음 위치넘어가기
            // 다음 넘어갈 위치 주기
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위안에 있고 방문안했으면 체크
            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visit[nx][ny]) {
                // 울타리면 넘어가기
                if (arr[x][y] != '#'){
                    dfs(nx, ny);
                }
            }
        }

    }

    public void soultion() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visit[i][j] && arr[i][j] =='v') {
                    sheep = 0;
                    wolf = 0;
                    dfs(i, j);

                    if(sheep > wolf) wolves-=wolf;
                    else sheeps-=sheep;
                }
            }
        }
    }

        public static void main(String[] args){
        Boj3184_Sheep t = new Boj3184_Sheep();
        Scanner kb = new Scanner(System.in);
        r = kb.nextInt();
        c = kb.nextInt();
        arr = new char[r][c];
        visit = new boolean[r][c];
        for(int i=0; i<r; i++) {
            String s = kb.next(); // 한줄 입력
            for(int j=0; j<c; j++) {
                arr[i][j] = s.charAt(j); // char 출력
                if(arr[i][j] == 'o') sheeps++;
                else if(arr[i][j] == 'v') wolves++;
            }
        }
        t.soultion();
        System.out.println(sheeps+" "+wolves);

    }

}
