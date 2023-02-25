package PG.Level1.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/12932
public class PG12932_자연수_뒤집어_배열만들기 {
    public List<Integer> solution(long n) {
        // 1. long to string
        String str  = String.valueOf(n);
        // 2. string to int[]
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            arr.add(str.charAt(i) - '0');
        }
        // 3. 역순 변환
        Collections.reverse(arr);

        return arr;
    }
    public static void main(String[] args) {
        PG12932_자연수_뒤집어_배열만들기 t = new PG12932_자연수_뒤집어_배열만들기();
        System.out.println(t.solution(12345));
    }
}
