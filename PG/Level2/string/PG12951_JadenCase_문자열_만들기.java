package PG.Level2.string;
// https://school.programmers.co.kr/learn/courses/30/lessons/12951
public class PG12951_JadenCase_문자열_만들기 {

    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        String[] arr = s.split(" ");

        for (int i = 0; i < arr.length; i++) {
            String sentence = arr[i];

            // 공백인지 체크
            if (sentence.length() == 0) {
                answer.append(" ");
            } else {
                // 1. 첫문자 알파벳인지 체크
                // 1-1. 알파벳이면
                // 첫글자 대문자로 변환
                answer.append(sentence.substring(0, 1).toUpperCase());
                answer.append(sentence.substring(1, sentence.length()).toLowerCase());
                answer.append(" ");
            }
        }
        // 마지막 공백처
        if (s.substring(s.length() - 1 , s.length()).equals(" ")) return answer.toString();
        return answer.substring(0, answer.length() - 1) .toString();
    }

    public static void main(String[] args) {
        PG12951_JadenCase_문자열_만들기 t = new PG12951_JadenCase_문자열_만들기();
        String s1 = "3people unFollowed me";
        String s2 = "for the last week";

        System.out.println(t.solution(s1));
        System.out.println(t.solution(s2));

    }
}
