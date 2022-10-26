package Practice.Book;

import java.io.IOException;
import java.util.Scanner;

public class B41_상하좌우 {

    public String solution(int n, char[] str) {
        String answer = "";
        int x = 1, y= 1; // 시작점
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char[] type = {'U', 'R', 'D', 'L'};
        int nx=1, ny=1;
        // 움직임 수만큼 이동
        for (char s : str) {
            // 다음 이동지점 go
            for(int i=0; i<type.length; i++) {
                if (s ==type[i]) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
            }

            // 공간 벗어나면 무시
            if(nx < 1 || ny<1 || nx > n || ny > n) continue;
            // 현재위치 저장
            x=nx;
            y=ny;
        }
        answer = nx + " " + ny;
        System.out.println(answer);

        return answer;
    }

    public static void main(String[] args) throws IOException {
        B41_상하좌우 t = new B41_상하좌우();
        int n = 5;
        char[] str = {'R','R' ,'R','U','D','D'};
        t.solution(n, str);

    }
}
