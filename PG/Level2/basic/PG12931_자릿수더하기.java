package PG.Level2.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class PG12931_자릿수더하기 {
    public int solution(int n) {
        int answer = 0;
        // 1. int to string
        String str = String.valueOf(n);
        // 2. string to int[]
        int[] list = new int[str.length()];
        for (int i = 0; i < list.length; i++) {
             answer += str.charAt(i) - '0'; // 아스키코드 변환
        }
        return answer;
    }

    public static void main(String[] args) {
        PG12931_자릿수더하기 t = new PG12931_자릿수더하기();
        System.out.println(t.solution(123));
        System.out.println(t.solution(987));

    }
}
