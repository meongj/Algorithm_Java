package PG.Level1.basic;

import java.util.Arrays;
import java.util.Collections;

// https://school.programmers.co.kr/learn/courses/30/lessons/12933
public class PG12933_정수_내림차순_배치하기 {

    public long solution(long n) {
        // 1. long to String
        String str = String.valueOf(n);
        // 2. String to int[]
        Integer[] arr = new Integer[str.length()];
        for (int i =0 ; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        // 3.  오름차순 정렬
        Arrays.sort(arr, Collections.reverseOrder());
        str = "";
        for (int i = 0; i < arr.length; i++) {
            str += String.valueOf(arr[i]);
        }
        return Long.valueOf(str);
    }

    public long solution2(long n) {
        // 1.string 배열로 만든다
        String[] arr = String.valueOf(n).split("");
        // 2. 내림차순 정렬
        Arrays.sort(arr);
        // 3. StringBuilder 담아서 reverse()
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return Long.valueOf(sb.reverse().toString());

    }

    public static void main(String[] args) {
        PG12933_정수_내림차순_배치하기 t = new PG12933_정수_내림차순_배치하기();
        System.out.println(t.solution(118372));
        System.out.println(t.solution2(118372));
    }
}
