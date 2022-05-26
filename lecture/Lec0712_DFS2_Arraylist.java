package lecture;

import java.util.ArrayList;
import java.util.Scanner;

//인접행렬 Arraylist로 저장
public class Lec0712_DFS2_Arraylist {
    static int n, m, answer=0;
    //static int[][] graph;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch;
    public void DFS(int v){
        if(v==n){
            answer++;
        }else {
            for (int nv : graph.get(v)){//각 Arraylist 가지고옴
                if(ch[nv]==0){
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0712_DFS t = new Lec0712_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch=new int[n+1];
        for (int i=0; i<m; i++){
            int a=kb.nextInt();
            int b=kb.nextInt();
            graph.get(a).add(b);//Arraylist에 추가
        }
        ch[1]=1;
        t.DFS(1);
        System.out.println(answer);
    }
}
