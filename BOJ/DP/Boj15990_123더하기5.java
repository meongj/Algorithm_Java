package BOJ.DP;

import java.util.Scanner;

public class Boj15990_123더하기5 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        long[][] dp = new long[100001][4]; //(만들n, [1,2,3]으로 끝날수)
        // 중복된 수 연속 사용불가! (2차원배열)
        //초기화
        dp[1][1]=1;
        dp[2][2]=1;
        dp[3][1]=1;
        dp[3][2]=1;
        dp[3][3]=1;
        for (int i=4; i<100001; i++) {
            dp[i][1] =(dp[i-1][2] + dp[i-1][3]) % 1000000009;
            dp[i][2] =(dp[i-2][1] + dp[i-2][3]) % 1000000009;
            dp[i][3] =(dp[i-3][1] + dp[i-3][2]) % 1000000009;
        }
        while (n > 0) {
            int num = kb.nextInt();
            long result= (dp[num][1] + dp[num][2] + dp[num][3]) % 1000000009;
            System.out.println(result);
            n--;
        }

    }
}
