package lecture;

import java.util.Scanner;

public class Lec0802_DFS {
    static int c, n, max=Integer.MIN_VALUE;

    public void DFS(int L, int sum, int[] arr){
        if(sum>c) return;

        if(L==n) {
            max=Math.max(max, sum);
            return;
        }
        else{
            DFS(L+1, sum+arr[L], arr);
            DFS(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Lec0802_DFS t = new Lec0802_DFS();
        Scanner kb = new Scanner(System.in);
        c = kb.nextInt();
        n = kb.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        t.DFS(0, 0, arr);
        System.out.println(max);
    }
}
