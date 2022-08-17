package PG.Level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12903
public class PG12903_가운데글자가져오기 {

    public String solution(String s) {
        StringBuffer answer = new StringBuffer();
        char[] c = s.toCharArray();
            int num = c.length / 2;
            if (c.length % 2 == 1) { // 홀
                answer.append(String.valueOf(c[num]));
            } else { //찍
                answer.append(String.valueOf(c[num-1])).append(c[num]);
            }
        return answer.toString();
    }

    public static void main(String[] args) {
        PG12903_가운데글자가져오기 t = new PG12903_가운데글자가져오기();
        System.out.println(t.solution("abcde"));
        System.out.println(t.solution("qwer"));
    }
}
