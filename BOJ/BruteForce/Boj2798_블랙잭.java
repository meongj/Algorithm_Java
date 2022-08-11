package BOJ.BruteForce;

import java.util.Scanner;

// https://www.acmicpc.net/problem/2798
public class Boj2798_블랙잭 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n+1];
        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                for (int k = j+1; k <n; k++) {
                    sum = arr[i] + arr[j] +  arr[k];
                    if(sum > m) continue;
                    max = Math.max(max, sum);
                }
            }
        }

        System.out.println(max);
    }
}
