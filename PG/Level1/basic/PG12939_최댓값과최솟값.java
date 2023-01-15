package PG.Level1.basic;

import java.util.Arrays;
// https://school.programmers.co.kr/learn/courses/30/lessons/12939
public class PG12939_최댓값과최솟값 {

    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        int[] newArr = new int[arr.length];

        for (int i=0; i<newArr.length; i++) {
            newArr[i] = Integer.parseInt(arr[i]);
        }
        Arrays.sort(newArr);
        answer = newArr[0] + " " + newArr[newArr.length-1];

        return answer;
    }

    public static void main(String[] args) {
        PG12939_최댓값과최솟값 t = new PG12939_최댓값과최솟값();
        System.out.println(t.solution("1 2 3 4"));
        System.out.println(t.solution("-1 -2 -3 -4"));
        System.out.println(t.solution("-1 -1"));

    }
}
