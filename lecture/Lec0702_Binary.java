package lecture;

import java.util.Scanner;

public class Lec0702_Binary {

    public void DFS(int n){
        if(n==0) return;
        else {
            DFS(n/2);
            System.out.print(n%2);
        }
    }

    public static void main(String[] args) {
        Lec0702_Binary t = new Lec0702_Binary();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        t.DFS(n);
    }
}

