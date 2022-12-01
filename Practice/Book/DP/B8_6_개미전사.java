package Practice.Book.DP;

import java.util.Scanner;

public class B8_6_개미전사 {
    public static void main(String[] args) {
        // 최댓값 구하기
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        // 식량 정보저장
        int[] d = new int[100];
        // 다이나믹 프로그래밍(dotton up)
        d[0] = arr[0];
        d[1] = Math.max(arr[0], arr[1]); // 최댓값 저장
        for(int i=2; i<n; i++)
            d[i] = Math.max(d[i-1], d[i-2] + arr[i]);

        System.out.println(d[n-1]);
    }
}
