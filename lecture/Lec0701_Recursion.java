package lecture;

import java.util.Scanner;

public class Lec0701_Recursion {
    public void DFS(int n){
        //재귀함수는 무조건 if ~ else 구조
        if(n==0) return;
        else {
            DFS(n - 1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        Lec0701_Recursion t = new Lec0701_Recursion();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        t.DFS(n);
    }
}
