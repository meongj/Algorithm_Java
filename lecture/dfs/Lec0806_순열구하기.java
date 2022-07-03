package lecture.dfs;

import java.util.Scanner;

public class Lec0806_순열구하기 {

    static int n, m;
    static int[] pm;
    static int[] ch;
    static int[] arr;
    public void dfs(int L) {
        if(L==m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
            return;
        }else {
            for (int i=0; i<n; i++) {
                if(ch[i]==0) {
                    ch[i]=1;
                    pm[L] = arr[i];
                    dfs(L + 1);
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Lec0806_순열구하기 t = new Lec0806_순열구하기();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        pm = new int[m]; //순열 저장
        ch=  new int[n];// 중복제거
        arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i]= kb.nextInt();
        }
        t.dfs(0);
    }
}
