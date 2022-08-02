package PG.Level1;

import java.util.ArrayList;
// https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class PG42840_모의고사 {
    public int[] solution(int[] answers) {
        int cnt1=0, cnt2=0, cnt3=0;
        int max = 0;
        int[] arr1 = {1,2,3,4,5}; //5
        int[] arr2 = {2,1,2,3,2,4,2,5}; //8
        int[] arr3 = {3,3,1,1,2,2,4,4,5,5}; //10

        for (int i=0; i<answers.length; i++) {
            if (answers[i] == arr1[i%5]) cnt1++;
            if (answers[i] == arr2[i%8]) cnt2++;
            if (answers[i] == arr3[i%10]) cnt3++;
        }

        // max값 구하기
        max = Math.max(cnt3, Math.max(cnt1, cnt2));

        // max 여러개 인 경우 1,2,3..순서대로 출력하기
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        if(cnt1 == max) tmp.add(1);
        if(cnt2 == max) tmp.add(2);
        if(cnt3 == max) tmp.add(3);

        int[] answer = new int[tmp.size()];

        for (int i=0; i<tmp.size(); i++) {
            answer[i] = tmp.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        PG42840_모의고사 t = new PG42840_모의고사();
        int[] answers = {1,2,3,4,5};
        int[] answers2 = {1,3,2,4,2};
        t.solution(answers);
        t.solution(answers2);

    }
}
