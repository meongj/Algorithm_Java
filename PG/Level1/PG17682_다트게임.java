package PG.Level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=java
public class PG17682_다트게임 {

    public int solution(String dartResult) {
        char[] s = dartResult.toCharArray();
        int[] score = new int[3]; // 각 다트 게임별 3번 점수 저장
        int index = -1; // 라운드 별 구분자 (0, 1, 2)
        String str = "";
        for (int i = 0; i < s.length; i++) {
            // 숫자면
            if (s[i] >= '0' && s[i] <= '9') {
                str += String.valueOf(s[i]);
            } else if (s[i] == 'D') { //제곱
                score[++index] = (int) Math.pow(Integer.parseInt(str), 2);
                str = "";
            } else if (s[i] == 'T') { //세제곱
                score[++index] = (int) Math.pow(Integer.parseInt(str), 3);
                str = "";
            } else if (s[i] == 'S'){
                score[++index] = Integer.parseInt(str);
                str = "";
            }
            else if (s[i] == '*') {
                // 이전 점수 2배
                if(index-1 >= 0) score[index-1] *= 2;
                // 이번 점수 2배
                score[index] *= 2;
            } else if (s[i] == '#') {
                score[index] *= -1;
            }
        }


        return score[0] + score[1] + score[2];
    }

    public static void main(String[] args) {
        PG17682_다트게임 t = new PG17682_다트게임();
        String result1 = "1S2D*3T";
        String result2 = "1D2S#10S";
        String result3 = "1D2S0T";
        String result4 = "1S*2T*3S";
        String result5 = "1D#2S*3S";

        t.solution(result1);
        t.solution(result2);
        t.solution(result3);
        t.solution(result4);
        t.solution(result5);



    }
}
