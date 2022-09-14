package PG.Level1;

// https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class PG12918_문자열다루기기본 {
    public static boolean isNumeric(String s) {
        return s.chars().allMatch(Character::isDigit);
    }
    public boolean solution(String s) {
        boolean answer = true;
        // 길이 4,6 확인
        if (s.length() == 4 || s.length() == 6) {
            if(!isNumeric(s)) {
                answer = false;
            }
        } else {
            answer = false;
        }
        return answer;
    }
    public static void main(String[] args) {
        PG12918_문자열다루기기본 t = new PG12918_문자열다루기기본();
        t.solution("a234");
    }
}
