package Practice.Book.DP;

import java.util.Scanner;

public class B8_5_1로만들기 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int x = kb.nextInt();
        int[] d = new int[30001]; // 메모이제이션(저장)
        // 횟수 최솟값 구하기!!
        // 다이나믹 프로그래밍 (down up)
        for (int i=2; i < x+1; i++) { // x
            // 현재 수에서 1을 빼는경우(횟수 +1더하기)
            d[i] = d[i-1] + 1;
            // 2로 나누어떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i/2]+1);
            // 3로 나누어떨어지는 경우
            if(i % 3 == 0)
                d[i] = Math.min(d[i], d[i/3]+1);
            // 5로 나누어떨어지는 경우
            if(i % 5 == 0)
                d[i] = Math.min(d[i], d[i/5]+1);
        }
        System.out.println(d[x]);
    }
}
