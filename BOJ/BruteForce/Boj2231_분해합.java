package BOJ.BruteForce;

import java.util.Scanner;

public class Boj2231_분해합 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int answer = 0;
        // 가장 작은 생성자 출력위한 작은 수부터 체크
        for (int i = 1; i <= n; i++) { // 1 ~ n
            int num = i;
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (i + sum == n) {
                answer  = i;
                break;
            }
        }
        System.out.println(answer);


    }
}
