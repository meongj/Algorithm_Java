package lecture;

import java.util.Scanner;

public class Lec0804_DFS {
    static int n,m;
    static int[] pm;
    public void DFS(int L){
        if(L==m){
            for (int x : pm) System.out.print(x+" ");
            System.out.println();
            return;
        }else{
            for(int i=1; i<=n; i++) {
                pm[L]=i;
                DFS(L + 1);
            }
        }
    }

    public static void main(String[] args) {
        Lec0804_DFS t = new Lec0804_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm= new int[m];
        t.DFS(0);
    }
}
