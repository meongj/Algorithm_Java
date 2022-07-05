package BOJ.DFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Boj2583_영역구하기 {

    static int m, n, k;
    static int[][] map;
    static int cnt ; //영역개수체크
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr;

    public void dfs(int x, int y) {
        cnt++;
        map[x][y] =1; //방문

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && nx < m && ny>=0 && ny<n && map[nx][ny]==0){
                    dfs(nx, ny);
                }
            }
    }

    public void solution() {
        for (int j=0; j<m; j++) {
            for (int k = 0; k < n; k++) {
                if(map[j][k]==0) {
                    cnt=0;
                    dfs(j, k);
                    arr.add(cnt);
                }
            }
        }
    }

    public static void main(String[] args) {
        Boj2583_영역구하기 t = new Boj2583_영역구하기();
        Scanner kb = new Scanner(System.in);
        m = kb.nextInt();
        n = kb.nextInt();
        k = kb.nextInt();
        map = new int[m][n];

        for (int i=0; i<k; i++){
            // 영역을 1 저장
            int x1= kb.nextInt();
            int y1 = kb.nextInt();
            int x2 = kb.nextInt();
            int y2 = kb.nextInt();
            for (int j=y1; j<y2; j++) {
                for (int k=x1; k<x2; k++) {
                    map[j][k] = 1;
                }
            }
        }
        arr = new ArrayList<>();
        t.solution();
        System.out.println(arr.size());
        Collections.sort(arr);
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }
}
