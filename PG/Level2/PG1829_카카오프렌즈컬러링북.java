package PG.Level2;

import java.util.Scanner;

public class PG1829_카카오프렌즈컬러링북 {

    static int cnt; //한 영역의 크기
    static int[] dx={-1,0,1,0};
    static int[] dy={0,1,0,-1};
    static boolean[][] visit;

    public void dfs(int x, int y, int[][] arr, int m, int n) {
        //방문여부 체크
        visit[x][y] = true;
        cnt++;
        for (int i=0; i<4;i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            // 범위안에 있는지, 방문했는지, 같은 영역인지 체크
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (arr[x][y] == arr[nx][ny] && !visit[nx][ny]) {
                    dfs(nx, ny, arr, m, n);
                }
            }
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; // 같은영역의 개수
        int maxSizeOfOneArea = 0; // 가장큰 영역의 칸수

        visit = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(picture[i][j] != 0 && !visit[i][j]) {
                    numberOfArea++;
                    dfs(i, j,picture, m, n);
                }
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                cnt = 0;
            }
        }
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

//        for (int x : answer)
//        System.out.print(x + " ");

        return answer;
    }
    public static void main(String[] args) {
        PG1829_카카오프렌즈컬러링북 t = new PG1829_카카오프렌즈컬러링북();
        Scanner kb = new Scanner(System.in);
        int m =6;
        int n =4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        // 0 : 색칱X, 그외: 색칠
        t.solution(m, n, picture);
    }
}
