package BOJ.DP;

import java.util.Scanner;
//https://www.acmicpc.net/problem/15989
public class PG15989_123더하기4 {
    public static void main(String[] args) {
     Scanner kb = new Scanner(System.in);
     int[][] dp = new int[10001][4];
     int n = kb.nextInt();
     dp[1][1] = 1;
     dp[2][1] = 1;
     dp[2][2] = 1;
     dp[3][1] = 1;
     dp[3][2] = 1;
     dp[3][3] = 1;
     for (int i = 4; i < 10001; i++) {
         dp[i][1] = dp[i-1][1];
         dp[i][2] = dp[i-2][1] + dp[i-2][2];
         dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
     }
     while (n >0) {
         int num = kb.nextInt();
         System.out.println(dp[num][1] + dp[num][2] +dp[num][3]);
         n--;
     }
    }
}
