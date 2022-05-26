package lecture;

import java.util.Scanner;

public class Lec0603_Factorial {
    public int DFS(int n){
        if(n==1) return 1;
        else return n*DFS(n-1);
    }

    public static void main(String[] args) {
        Lec0603_Factorial t = new Lec0603_Factorial();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(t.DFS(n));
    }
}
