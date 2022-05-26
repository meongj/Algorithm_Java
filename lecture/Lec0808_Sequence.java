package lecture;

import java.util.Scanner;
/*
규칙이 있는 순열이 있다
 */
public class Lec0808_Sequence {
    static int n, f;
    static int[] ch;
    static int[] p, b;
    boolean flag = false;
    int[][] dy = new int[35][35];

    public int combi(int n, int r){
        if(dy[n][r]>0) return dy[n][r];
        if(n==r || r==0) return 1;
        else return dy[n][r]=combi(n-1, r-1)+combi(n-1, r);
    }

    public void DFS(int L, int sum) {
        if(flag) return;
        if(L==n){
            if(sum==f) {
                for (int x : p) {
                    System.out.print(x + " ");
                }
                flag=true;//답 찾음
            }
        }else{
            for (int i=1; i<=n; i++){
                //순열만들기
                if(ch[i]==0){ //사용안했으면
                    ch[i]=1;//사용했다 표시
                    p[L]=i;
                    DFS(L+1, sum+(p[L]*b[L]));
                    ch[i]=0;
                }
            }
        }
    }
    public static void main(String[] args) {
        Lec0808_Sequence t = new Lec0808_Sequence();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        f = kb.nextInt();
        b = new int[n]; //순열저장(갈라진것들 배열)
        p = new int[n];
        ch = new int[n+1]; // 체크배열
        for (int i=0; i<n; i++){
            b[i] = t.combi(n-1, i);
        }

        t.DFS(0, 0);
    }
}
