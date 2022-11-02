package Practice.Book;

import java.util.Scanner;

public class B03_게임개발 {
    private static int direction = 0;
    // 왼쪽 회전
    public static void turn_left() {
        direction -= 1;
        if (direction == -1) direction = 3;
    }



    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt(); // 세로
        int m = kb.nextInt(); // 가로
        int x = kb.nextInt(); // x축
        int y = kb.nextInt(); // y축
        direction = kb.nextInt(); // 방향(0:북, 1:동, 3:남, 3:서)

        int[][] map = new int[m][n]; // 0:육지, 1:바다
        for (int i = 0; i <m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = kb.nextInt();
            }
        }
        int[][] visit = new int[m][n]; // 방문한 곳체크(1:방문, 0:방문x)
        int[] dx = {-1, 0, 1, 0}; // (북동남서)
        int[] dy = {0, 1, 0, -1};
        int cnt = 1; //이동횟수
        int turn_time = 0; // 네방향 모두 갔는지 횟수
        // 현재위치 저장
        visit[x][y] = 1;
        while(true) {
            // 1. 왼쪽 회전
            turn_left();
            //  전진
            int nx = x + dx[direction];
            int ny = y + dx[direction];
            // 2-1. 가보지 않은 곳인지 체크, 바다x
            if (visit[nx][ny] == 0 && map[nx][ny]==0) {
                // 방문했다고 표시
                visit[nx][ny] = 1;
                x = nx;
                y = ny;
                // 이동횟수 증가
                cnt++;
                turn_time = 0; // 갔으니까 초기화
                continue;
            }
            // 2-2. 가본 곳인지 체크
            else {
                turn_time++;
            }
            // 3.  네 방향 모두 간경우
            if (turn_time == 4) {
                // 뒤....방향...유지한채
                nx = x - dx[direction];
                ny = y - dy[direction];
                // 한칸 뒤로
                if (map[nx][ny] == 0) { // 이동할수 있다면 이동go
                    x = nx;
                    y = ny;
                } else { // 이동못하면 끝
                    break;
                }
                turn_time = 0; // 이동했다면 1번으로 다시 go
            }
        }
        System.out.println(cnt);
    }
}
