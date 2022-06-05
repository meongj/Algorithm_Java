package BOJ.DP;

import java.util.Scanner;

public class Boj9095_123Add {
    static int[] dy;

    static int solution(int n){
        dy = new int[11];
        dy[1]=1;
        dy[2]=2;
        dy[3]=4;
        for (int i=4; i<=n; i++){
            dy[i]=dy[i-3]+dy[i-2]+dy[i-1];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Boj9095_123Add t = new Boj9095_123Add();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        for(int i=0; i<n; i++){
            int T = kb.nextInt();
            System.out.println(t.solution(T));
        }
    }
}
