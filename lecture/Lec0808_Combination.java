package lecture;

import java.util.Scanner;

public class Lec0808_Combination {
    static int[] combi;
    static int n, m;
    public void DFS(int L, int s){//(레벨, 시작번호)
        if(L==m){
            for (int x : combi) System.out.print(x+" ");
            System.out.println();
        }else{
            for(int i=s; i<=n; i++){
                combi[L]=i;
                DFS(L+1, i+1);
            }
        }

    }
    public static void main(String[] args) {
        Lec0808_Combination t = new Lec0808_Combination();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        combi= new int[m];
        t.DFS(0,1);

    }
}
