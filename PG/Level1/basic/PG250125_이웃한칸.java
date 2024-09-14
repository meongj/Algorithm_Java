package PG.Level1.basic;

/**
 * 풀이 날짜 : 2024/09/14
 * 해결 여부 : Y
 * https://school.programmers.co.kr/learn/courses/30/lessons/250125
 */
public class PG250125_이웃한칸 {

    public static int solution(String[][] board, int h, int w) {
        int answer = 0;

        String current = board[h][w];
        int n = board.length;
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        for (int i=0; i<4; i++) {
            int x = h + dx[i];
            int y = w + dy[i];

            if (x >= 0 && x < n && y >=0 && y < n ) {
                // 같은 색깔이라면 카운트 증가
                if (board[x][y].equals(current)) {
                    answer++;
                }
            }

        }
        return answer;
    }
    public static void main(String[] args) {
        String[][] board = {
                {"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}
        };

        solution(board, 1, 1);

        String[][] board02 = {
                {"yellow", "green", "blue"},
                {"blue", "green", "yellow"},
                {"yellow", "blue", "blue"}
        };
        solution(board02, 0, 1);


    }
}
