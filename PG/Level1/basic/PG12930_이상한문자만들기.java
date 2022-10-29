package PG.Level1.basic;
// https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class PG12930_이상한문자만들기 {

    public String solution(String s) {
        String answer = "";
        int idx = 0;
        // 짝수 ->대문자, 홀수 -> 소문자
        for (int i = 0; i < s.length(); i++) {
            // 공백제외 짝홀수 세기
            if(s.charAt(i) == ' ') {
                idx = 0;
                answer += " ";
                continue;
            }
            if(idx++%2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG12930_이상한문자만들기 t = new PG12930_이상한문자만들기();
        t.solution("  tRy hello  WORLD   ");
    }
}
