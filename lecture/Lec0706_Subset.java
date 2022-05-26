package lecture;
/*
부분 집합 구하기
 */
public class Lec0706_Subset {
    static int n;
    static int[] ch;
    public void DFS(int L){
        if(L==n+1) {
            String tmp="";
            for(int i=1; i<=n; i++) {
                if(ch[i]==1) {//체크배열 출력
                    tmp+=(i+" ");
                }
            }
            if(tmp.length()>0) System.out.println(tmp);//공집합
            return;
        }
        else{
            ch[L]=1;//사용함
            DFS(L + 1);//왼
            ch[L]=0;//사용하지 않음
            DFS(L + 1);//오
        }
    }

    public static void main(String[] args) {
        Lec0706_Subset t = new Lec0706_Subset();
        n=3;
        ch = new int[n+1];
        t.DFS(1);
    }
}
