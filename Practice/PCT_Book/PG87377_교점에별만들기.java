package Practice.PCT_Book;

import java.nio.channels.Pipe;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PG87377_교점에별만들기 {

    // x, y 좌표 저장
    private static class Point {
        public final long x, y;

        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    // 1. 교점찾기 (계산식 필요)
    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        // x
        double x = (double) (b1*c2 - b2*c1) / (a1*b2 - a2*b1);
        // y
        double y = (double) (a2*c1 - a1*b2) / (a1*b2 - a2*b1);
        if (x%1 !=0 || y%1 != 0) return null; // 정수가 아니라면(소수) null 리턴
        // 교점 반환
        return new Point((long)x, (long)y);
    }


    // 2. 최소사각형 범위찾기
    // 2-1. 최소범위 구하기
    private static Point getMinimumPoint(List<Point> points) {
        // 가장 작은 좌표 찾기
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for(Point p : points) {
            // 작은 값으로 계속 저장
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.y;
        }

        return new Point(x, y);
    }
    // 2-2. 최대범위 구하기
    private static Point getMaximumPoint(List<Point> points) {
        // 가장 큰 좌표 찾기
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        for (Point p : points) {
            if (x < p.x) x = p.x;
            if (y < p.y) y = p.y;
        }
        return new Point(x, y);
    }

    public static String[] solution(int[][] line) {
        String[] answer = {};

        List<Point> points = new ArrayList<>(); // 교점 저장
        for (int i =0; i< line.length; i++) {
            for (int j= i+1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2],
                            line[j][0], line[j][1], line[j][2]);
                if (intersection != null) { // 교점이 없을 수도 있다
                    points.add(intersection);
                }
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);
        // 최소 최대 범위 구하기
        int witdh = (int) (maximum.x - minimum.x + 1);
        int height = (int) (maximum.y - minimum.y + 1);

    // 3. 별찍기
        char[][] arr  = new char[witdh][height];
        for (char[] row : arr) {
            Arrays.fill(row, '.'); // 전체 공백으로 만들고
        }
        // 좌표-> 2차원 배열로 나타내가
        for (Point p : points) {
            int x = (int) (p.x - minimum.x);
            int y = (int) (maximum.y - p.y);
            arr[x][y] = '*'; // 교점 저장
        }

        String[] result = new String[arr.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] line = {
                // x, y, 기울기
                {2, -1, 4},
                {-2, -1, 4},
                {0, -1, 1},
                {5, -8, -12},
                {5, 8, 12}
        };
        solution(line);
    }

}
