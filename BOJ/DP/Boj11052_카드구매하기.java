package BOJ.DP;

import java.util.Scanner;
// https://www.acmicpc.net/problem/11052
// 정답률 61%
public class Boj11052_카드구매하기 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n+1];
        //카드금액
        for (int i = 1; i <= n; i++) {
            arr[i] = kb.nextInt();
        }
        //최대값 저장
        /*
        카드1개 구매 -> 키드 i-1개 구매
        카드2개 구매 -> 카드 i-2개 구매
        카드3개 구매 -> 카드 i-3개 구매
        ...
         */
        int[] dp = new int[10001];
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                //i번 카드 선태하는 경우 가격 vs (i-1,i-2,i-3...)선택하는 경우 가격 + 나머지 가격
                dp[i] = Math.max(dp[i] , dp[i-j] + arr[j]);
            }
        }
        System.out.println(dp[n]);

    }
}
