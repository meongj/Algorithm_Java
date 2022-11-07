package Practice.Book.DFS;

import java.util.Scanner;

public class B03_음료수얼려먹기 {
    static int n=0, m=0;
    static int[][] map;
    public static boolean dfs(int x, int y) {
        // 범위 벗어나는지 체크
        if(x<=-1 || x>=n || y<=-1 || y>=m)
            return false;

        // 아직방문 안한 곳아라면
        // 0 = 뚫린곳&방문 안한곳
        if (map[x][y]==0) {
            map[x][y]=1; // 방문
            // 상하좌우 방문
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = kb.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int cnt = 0; // 방문횟수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(dfs(i, j)) { // 방문한경우
                    cnt++;
                }
            }
        }
        System.out.println("result ==> "+cnt);
    }
}
