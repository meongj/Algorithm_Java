package PG.Level1.dp;
//https://school.programmers.co.kr/learn/courses/30/lessons/86491


public class PG86491_최소직사각형 {

    public int solution(int[][] sizes) {
        int answer = 0; //최소직사각형 크기
        int row_max = 0; //가로 최대길이
        int col_max = 0; //세로 최대길이
        //회전시 포함 제일큰 가로,세로 포함
        //가로 기준 max, 세로기준 max
        for (int i=0; i<sizes.length; i++) {
            int x = sizes[i][0]; //가로
            int y = sizes[i][1]; //세로
            //swapping
            if(x > y) {
                int tmp = sizes[i][1];
                sizes[i][1] = sizes[i][0];
                sizes[i][0] = tmp;
            }
            row_max = Math.max(sizes[i][0], row_max);
            col_max = Math.max(sizes[i][1], col_max);
        }
        answer = row_max*col_max;

        return answer;
    }
    public static void main(String[] args) {
        PG86491_최소직사각형 t = new PG86491_최소직사각형();
        int[][] sizes ={{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        t.solution(sizes);
    }
}
