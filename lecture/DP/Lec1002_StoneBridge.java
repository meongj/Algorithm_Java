package lecture.DP;

import java.util.Scanner;

public class Lec1002_StoneBridge {
    static int dp[];

    public static int solution(int n){
        dp[1]=1;
        dp[2]=2;
        for (int i=3; i<=n+1; i++){
            dp[i]=dp[i-2]+dp[i-1];
        }
        //개울을 다 건너고 최종 마지막 끝쪽으로 와야함
        return dp[n+1];
    }

    public static void main(String[] args) {
        Lec1002_StoneBridge t = new Lec1002_StoneBridge();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dp = new int[n+2];
        System.out.println(t.solution(n));

    }
}
