package PG.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/70128
public class PG70128_내적 {

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i=0; i<a.length; i++) answer += a[i] * b[i];
        return answer;
    }
    public static void main(String[] args) {
        PG70128_내적 t = new PG70128_내적();
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        t.solution(a, b);

    }
}
