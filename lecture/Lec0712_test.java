package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Lec0712_test {
    static int n, m, answer=0;
    static  ArrayList<ArrayList<Integer>> graph;//갈 수 있는 경로 저장
    static int ch[];

    public void DFS(int v){
        if(v==n){
            answer++;
        }else{
           for (int nv : graph.get(v)){
               if(ch[nv]==0){
                   ch[nv]=1;
                   DFS(nv);
                   ch[nv]=0;
               }
           }
        }
    }

    public static void main(String[] args) {
        Lec0712_test t = new Lec0712_test();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];//체크배열 1부터시작
        //값 저장
        for (int i=0; i<m; i++){//0부터 시작해도 상관없지, m번만 돌아서 값넣으면 되니까
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);//a번과 연결된 간선의 개수 저장
        }
        ch[1]=1;
        t.DFS(1);
        System.out.println(answer);
    }
}
