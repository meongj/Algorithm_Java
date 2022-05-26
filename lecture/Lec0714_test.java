package lecture;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0714_test {
    static int n, m;
    static ArrayList<ArrayList<Integer>> graph;
    static int ch[], dis[];//최소거리 저장

    public static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        ch[v]=1;
        dis[v]=0;
        q.offer(v);
        while (!q.isEmpty()){
            int cv = q.poll();
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
        Lec0714_test t = new Lec0714_test();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Integer>>();
        ch = new int[n+1];
        for (int i=0; i<m; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            graph.get(a).add(b);
        }
        t.BFS(1);
    }
}
