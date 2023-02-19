package PG.Level3.dp;
// https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class PG12914_멀리뛰기 {
    /**
     * 뛸 수 있는 모든 경우의 수 구하기
     * n의 개수가 2000까지이기 때문에
     * 더 빨리 구할 수 있는 dfs가 아닌 dp로 문제를 풀었다
     *
     * n=4 일 경우 경우의 수는
     * dp[4] = dp[3] + dp[2];
     * n=3
     * dp[3] = dp[2] + dp[1];
     * 규칙성 발견
     */
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < 2001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        PG12914_멀리뛰기 t = new PG12914_멀리뛰기();
        System.out.println(t.solution(4));
        System.out.println(t.solution(3));
    }
}
