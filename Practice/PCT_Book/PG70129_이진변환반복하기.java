package Practice.PCT_Book;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class PG70129_이진변환반복하기 {

    public static int[] solution(String s) {
        int loop = 0;
        int removed = 0;

        // s -> 1 될때까지 반복
        while (!s.equals("1")) {
            // s 변환하며 loop, removed 누적
            int zeros = countZero(s);
            loop += 1; //
            removed += zeros;

            // 문자열 s 변환
            // 1의 개수 (길이 - 0의 개수)
            int ones = s.length() - zeros;
            s = Integer.toString(ones, 2); // 1의 개수 -> 2진법
        }
        return new int[] {loop, removed};
    }

    //  문자열에 포함된 0의 개수 세기
    private static int countZero(String s) {
        int zeros =0 ;
        for (char c : s.toCharArray()) {
            if (c == '0') zeros++;
        }
        return zeros;
    }
    public static void main(String[] args) {
        solution("0110");
    }
}
