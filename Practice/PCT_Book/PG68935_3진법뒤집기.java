package Practice.PCT_Book;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class PG68935_3진법뒤집기 {

    public static int solution(int n) {
        // 1. 정수를 3진법으로 변환
        String str = Integer.toString(n, 3);
        // 2. 변환된 문자열 뒤집기
        String reversed = new StringBuilder(str).reverse().toString();
        // 3. 10진법로 변환
        return Integer.valueOf(reversed, 3);
    }
    public static void main(String[] args) {

        int n = 45;
        System.out.println(solution(n));

    }
}
