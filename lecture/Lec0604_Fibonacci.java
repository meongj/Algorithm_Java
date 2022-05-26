package lecture;

import java.util.Scanner;

public class Lec0604_Fibonacci {
    static int[] fibo;//메모이제이션 (기록)
    public int DFS(int n){
        if(fibo[n]>0) return fibo[n];
        if(n==1) return fibo[n]=1;
        else if(n==2) return fibo[n]=1;
        else return fibo[n] = DFS(n-2) + DFS(n-1);
    }

    public static void main(String[] args) {
        Lec0604_Fibonacci t = new Lec0604_Fibonacci();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        fibo = new int[n+1];
        t.DFS(n);
        for(int i=1; i<=n; i++) System.out.print(fibo[i] + " ");
    }
}
