package PG.Level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12922
public class PG12922_수박수박수박 {

    public String solution(int n) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if(i % 2 == 0) { //짝
                answer += "수";
            }else if(i % 2 == 1) { // 홀
                answer += "박";
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG12922_수박수박수박 t = new PG12922_수박수박수박();
        System.out.println(t.solution(3));
        System.out.println(t.solution(4));
    }
}
