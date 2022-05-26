package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Lec0801_DFS {
    static String answer="NO";
    static int n, total=0;
    boolean flag=false;
    public void DFS(int L, int sum, int[] arr){
        if(flag) return;//재귀 end
        if(sum>(total/2)) return;
        if(L==n){//끝이니까 end
            if((total-sum)==sum){//절반이면
                answer="YES";
                flag=true;
            }
        }else{
            //두갈래로 뻗는다
            DFS(L+1, sum+arr[L], arr);//부분집합o
            DFS(L+1, sum, arr);//부분집합x
        }
   }

    public static void main(String[] args) {
        Lec0801_DFS t = new Lec0801_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]=kb.nextInt();
            total+=arr[i];
        }
        t.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
