package PG.Level1.basic;

import java.util.ArrayList;

// https://school.programmers.co.kr/learn/courses/30/lessons/12906
public class PG12906_같은숫자는싫어 {
    public ArrayList<Integer>  solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int x = arr[0];
        answer.add(x);
        for (int i = 1; i < arr.length; i++) {
            if (x != arr[i]) {
                answer.add(arr[i]);
                x = arr[i];
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        PG12906_같은숫자는싫어 t = new PG12906_같은숫자는싫어();
        int[] arr1 = {1,1,3,3,0,1,1};
        int[] arr2 = {4,4,4,3,3};
        t.solution(arr1);
        t.solution(arr2);

    }
}
