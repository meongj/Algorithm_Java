package lecture;

import java.util.Scanner;

public class Lec0807_Memoization {
    int[][] dy = new int[35][35]; //합 저장
    public int DFS(int n, int r){
        if (dy[n][r]>0) return dy[n][r];
        if (n==r || r==0){
            return 1;
        }else{
            return dy[n][r]=DFS(n-1, r-1) + DFS(n-1, r);
        }
    }

    public static void main(String[] args) {
        Lec0807_Memoization t = new Lec0807_Memoization();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int r = kb.nextInt();
        System.out.println(t.DFS(n, r));
    }
}
