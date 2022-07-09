package PG.Level2;

import java.util.Scanner;

public class PG12945_피보나치수 {

    public int fibonacci(int n) {
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 1;
        // 시간 초과로 인한 비재귀로 풀기
        // cpu 최소 기억단위 초과로 인한 다음과 같이 계산
        // (A+B)%C = (A%C) + (B%C)
        for (int i=3; i<=n; i++) {
            arr[i] = (arr[i-2] + arr[i-1]) % 1234567;
        }
        return arr[n];
    }

    public int solution(int n) {
        return fibonacci(n);
    }

    public static void main(String[] args) {
        PG12945_피보나치수 t = new PG12945_피보나치수();
        int n = 3;
        t.solution(n);
    }
}
