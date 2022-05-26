package lecture;

import java.util.ArrayList;
import java.util.Scanner;


public class Lec0803_DFS {
    static int n, m, max=Integer.MIN_VALUE;

    public void DFS(int L, int sum, int time, int[] ps, int[] pt){
        if(m < time) return;
        if(L==n){
            max = Math.max(sum, max);
            return;
        }else{
            DFS(L+1, sum+ps[L], time+pt[L], ps, pt);
            DFS(L+1, sum, time, ps, pt);
        }
    }

    public static void main(String[] args) {
        Lec0803_DFS t = new Lec0803_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for(int i=0; i<n; i++){
            a[i] = kb.nextInt();//score
            b[i] = kb.nextInt();//time
        }
        t.DFS(0,0,0,a, b);

        System.out.println(max);
    }
}
