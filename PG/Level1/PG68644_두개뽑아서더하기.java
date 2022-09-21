package PG.Level1;

import java.util.ArrayList;
import java.util.Collections;
// https://school.programmers.co.kr/learn/courses/30/lessons/68644
public class PG68644_두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                int val = numbers[i] + numbers[j];
                if (!list.contains(val))
                    list.add(numbers[i] + numbers[j]);
            }
        }
        // 오름차순 정렬
        Collections.sort(list);

        int[] answer = new int[list.size()];
        for (int i =0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        PG68644_두개뽑아서더하기 t = new PG68644_두개뽑아서더하기();
        int[] arr = {2,1,3,4,1};
        t.solution(arr);
        int[] arr02 = {5,0,2,7};
        t.solution(arr02);

    }
}
