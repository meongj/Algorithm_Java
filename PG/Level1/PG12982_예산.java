package PG.Level1;

import java.util.Arrays;

public class PG12982_예산 {

    public int solution(int[] d, int budget) {
        int answer = 0;

        // 작은 수 부터 정렬해서 가장 많은 개수 받도록 만든다
        Arrays.sort(d);

        // 개수 체크
        for(int i = 0; i < d.length; i++) {
            budget -= d[i];
            if(budget >= 0) answer++;
            else break;
        }

        return answer;
    }


    public static void main(String[] args) {
        PG12982_예산 t = new PG12982_예산();
        int[] d = {1,3,2,5,4};
        int budget = 9;
        System.out.println(t.solution(d, budget));
    }
}
