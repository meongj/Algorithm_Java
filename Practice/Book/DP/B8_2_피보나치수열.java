package Practice.Book.DP;

public class B8_2_피보나치수열 {

    int[] d = new int[100];

    public int fibo(int x) {
        // 종료조건 (1 or 2일때 1을 반환)
        if (x == 1 || x == 2) return 1;
        // 이미 계산한적 있는 문제라면 그대로 반환
        if (d[x] != 0)
            return d[x];
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[x] = fibo(x-1) + fibo(x - 2);
        return d[x];
    }

    public static void main(String[] args) {
        B8_2_피보나치수열 t = new B8_2_피보나치수열();
        System.out.println(t.fibo(99));
    }
}
