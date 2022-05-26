package lecture;

import java.util.Scanner;

public class Lec0806_RealArr {
    static int n, m;
    static int[] pm, ch, arr;

    public void BFS(int L){
        if(L==m){
            for(int x : pm) System.out.print(x+" ");
            System.out.println();
            return;
        }else{
            for(int i=0; i<n; i++){
                if(ch[i]==0) {
                    ch[i]=1;
                    pm[L] = arr[i];
                    BFS(L + 1);
                    ch[i]=0;//체크해제!!!!
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0806_RealArr t = new Lec0806_RealArr();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        ch = new int[n];
        pm = new int[m];
        t.BFS(0);
    }
}
