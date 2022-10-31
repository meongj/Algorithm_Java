package Practice.Book;

import java.util.Scanner;

public class B02_왕실의나이트 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        int row = Integer.parseInt(str.substring(1)) -1; // 행
        int col = str.substring(0).charAt(0) - 97; // 열(알파벳a,b,c,....)
        int cnt = 0;

        int[] dx = {-2, -2, 2, 2, -1, 1, -1, 1};
        int[] dy = {-1, 1, -1, 1, -2, -2, 2, 2};

        for (int i = 0; i < dx.length; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || ny < 0 || nx > 8 || ny > 8) {
                continue;
            }
            cnt++;
        }
        System.out.println(cnt);

    }
}
