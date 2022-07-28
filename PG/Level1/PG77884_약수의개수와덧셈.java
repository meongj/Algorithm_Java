package PG.Level1;
//https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class PG77884_약수의개수와덧셈 {
    public int solution(int left, int right) {
        int answer = 0; //sum
        for (int i=left; i<=right; i++) {
            int cnt = 0;// 약수의 개수
            for (int j=1 ; j<=i; j++) {
                if (i%j == 0) cnt++;
            }
            // 약수의 개수 짝수이면
            if (cnt %2 ==0) answer += i;
            else answer -= i;
        }
        return answer;
    }

    public static void main(String[] args) {
        PG77884_약수의개수와덧셈 t = new PG77884_약수의개수와덧셈();
        t.solution(13, 17);
        t.solution(24, 27);
    }
}
