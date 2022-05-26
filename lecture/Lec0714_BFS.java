package lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0714_BFS {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] ch, dis;
    public void DFS(int v){
        Queue<Integer> q = new LinkedList<>();
        ch[v]=1;
        dis[v]=0;
        q.offer(v);
        while (!q.isEmpty()){
            int cv=q.poll();
            for(int nv : graph.get(cv)){
                if(ch[nv]==0){
                    ch[nv]=1;
                    q.offer(nv);
                    dis[nv]=dis[cv]+1;
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
        t.DFS(1);

        for (int i=2; i<n; i++){
            System.out.print(dis[i]+" ");
        }
    }
}
