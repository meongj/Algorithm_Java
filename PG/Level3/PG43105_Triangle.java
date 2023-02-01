package PG.Level3;

public class PG43105_Triangle {
    /*
    https://school.programmers.co.kr/learn/courses/30/lessons/43105
    꼭대기에서 바닥까지 이어지는 경로중 거쳐간 숫자의 합이 최대
    대각선 방향으로 오른쪽, 왼쪽으로 이동가능
    top-down 방
    왼 + 자기자신 vs 오 + 자기자신 최댓값 저장
     */
    public int solution(int[][] triangle) {
        int answer = 0;
        // 위에서부터 아래로 합계를 더하면서 배열에 저장한다
        int[][] dp = new int[triangle.length][triangle.length];
        // 초기화
        dp[0][0] = triangle[0][0];
        dp[1][0] = dp[0][0] + triangle[1][0];
        dp[1][1] = dp[0][0] + triangle[1][1];

        for(int i = 2; i < triangle.length; i++ ) {
            for(int j = 0; j <=i ; j++) {
                // 왼쪽
                if (j == 0) {
                    dp[i][j] = dp[i-1][0] + triangle[i][0];
                }
                // 오른쪽
                else if (j == i) {
                    dp[i][j] = dp[i-1][i-1] +  triangle[i][j];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j-1] + triangle[i][j], dp[i-1][j] + triangle[i][j]);
                }
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PG43105_Triangle t = new PG43105_Triangle();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(t.solution(triangle));
    }
}
