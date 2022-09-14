package PG.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/82612
public class PG82612_부족한금액계산하기 {
    public long solution(int price, int money, int count) {
        int answer = 0;
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += price * i;
        }
        answer = money - sum;
        if (answer < 0) answer = Math.abs(answer);
        else answer = 0;

        return answer;
    }

    public static void main(String[] args) {
        PG82612_부족한금액계산하기 t = new PG82612_부족한금액계산하기();
        t.solution(3,20,4);
    }
}
