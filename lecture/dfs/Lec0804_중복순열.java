package lecture.dfs;

import java.util.Scanner;

public class Lec0804_중복순열 {

    static int n, m;
    static int pm[]; // 뽑을 번호 담을 배열
    public void dfs(int L) {
        if(L == m) {
            for (int x : pm) System.out.print(x +" ");
            System.out.println();

        }else {
            for (int i=1; i<=n; i++) {
                pm[L] = i;
                dfs(L + 1);
            }

        }
    }

    public static void main(String[] args) {
        Lec0804_중복순열 t = new Lec0804_중복순열();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m];

        t.dfs(0);


    }
}
