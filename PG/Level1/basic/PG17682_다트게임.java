package PG.Level1.basic;
// https://school.programmers.co.kr/learn/courses/30/lessons/17682
public class PG17682_다트게임 {
    // *문자열 변형문제*
    public int solution(String dartResult) {
        char[] c  = dartResult.toCharArray();
        int[] scores = new int[3]; // 점수저장
        int index = -1; // 다트게임 횟수(1, 2, 3)
        String s = "";
        for (int i = 0; i < c.length; i++) {
            // 숫자일 경우
            if (Character.isDigit(c[i])) {
                s += String.valueOf(c[i]);
                continue;
            }
            // single 일 경우
            else if (c[i] == 'S') {
                scores[++index] = Integer.parseInt(s);
                s = "";
            }
            // Double 일 경우
            else if (c[i] == 'D') {
                // 제곱
                scores[++index] = (int) Math.pow(Integer.parseInt(s), 2);
                s = "";
            }
            // Triple 일 경우
            else if (c[i] == 'T') {
                // 세제곱
                scores[++index] = (int) Math.pow(Integer.parseInt(s), 3);
                s = "";
            }
            // 옵션 확인
            else if (c[i] == '*') {
                // 이전점수 2베
                if (index - 1 >= 0) scores[index - 1] *= 2;
                // 이번점수 2베
                scores[index] *= 2;
            }
            else if (c[i] == '#') {
                scores[index] *= -1;
            }
        }
        return scores[0] + scores[1] + scores[2];

    }
    public static void main(String[] args) {
        PG17682_다트게임 t = new PG17682_다트게임();
        String str = "1S2D*3T";
        String str2 = "1D2S#10S\t";

        System.out.println(t.solution(str2));
    }
}
