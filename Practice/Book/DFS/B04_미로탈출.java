package Practice.Book.DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B04_미로탈출 {
    static int n, m;
    static int[][] map;
    static int[] dx = {-1,1,0,0}; // 상하좌우
    static int[] dy = {0,0,-1,1};

    // 좌표저장을 위한 생성자
    static class Location{
        int x, y;
        Location(int x, int y){
            this.x = x;
            this.y = y;
        }
    }


    // 최단거리 구하기
    public int bfs(int x, int y) {
        // queue를 이용하여 queue가 빌때까지 반복하기
        Queue<Location> queue = new LinkedList<>();
        queue.offer(new Location(x, y));

        while(!queue.isEmpty()) {
            Location loc = queue.poll();
            x = loc.x; y = loc.y;
            System.out.println(x + " " + y);
            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 공간 벗어나는지 체크
                if (nx < 0 || nx >=n || ny <0 || ny >=m)
                    continue;

                // 벽인 경우 무시
                if(map[nx][ny] == 0)
                    continue;

                // 처음 방문하는 노드만 최단거리 기록
                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[x][y] + 1; // 방문횟수 증가
                    queue.offer(new Location(nx,ny));
                }
            }
        }
        return map[n-1][m-1];
    }

    public static void main(String[] args) {
        B04_미로탈출 t = new B04_미로탈출();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = kb.next();
            for(int j = 0; j < s.length(); j++) {
                int k = s.charAt(j) - '0';
                map[i][j] = k;
            }
        }

        System.out.println(t.bfs(0,0));
    }
}
