package BOJ.DP;

import java.util.Scanner;

public class Boj15988_123더하기3 {

    static long[] arr = new long[1000001];

    public void dp() {
        arr[0] = 1; // 1만드는 방법수
        arr[1] = 2; // 2만드는 방법수
        arr[2] = 4; // 3만드는 방법수
        for (int i=3; i<1000001; i++) {
            arr[i] = (arr[i-3] + arr[i-2] + arr[i-1]) % 1000000009;
        }
    }

    public static void main(String[] args) {
        Boj15988_123더하기3 t = new Boj15988_123더하기3();
        Scanner kb = new Scanner(System.in);
        t.dp();

        int n =  kb.nextInt();
        for (int i=0; i<n; i++) {
            int input = kb.nextInt();
            System.out.println(arr[input-1]);
        }

    }
}
