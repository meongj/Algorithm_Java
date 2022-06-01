package lecture.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Edge_0807 implements Comparable<Edge_0807>{
    public int v1;//출발점
    public int v2;//마지막점
    public int cost;//간선값
    Edge_0807(int v1, int v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_0807 o) {
        return this.cost - o.cost;
    }
}

public class Lec0907_Kruskal {
    static int[] unf;
    //같은 그룹인지 확인
    public static int find(int v){
        if(v==unf[v]) return v;
        else return unf[v]=find(unf[v]);
    }

    public static void Union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa]=fb; //다른 그룹
    }

    public static void main(String[] args) {
        Lec0907_Kruskal t = new Lec0907_Kruskal();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        unf = new int[n+1];
        ArrayList<Edge_0807> arr = new ArrayList<>();
        for (int i=1; i<=n; i++) unf[i]=i;
        for (int i=0; i<m; i++){
            int a = kb.nextInt();
            int b= kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Edge_0807(a, b, c));
        }
        int answer=0;
        Collections.sort(arr);
        for (Edge_0807 ob : arr){
            int fv1=find(ob.v1);
            int fv2=find(ob.v2);
            if(fv1!=fv2) {
                answer+=ob.cost;
                //같은 집합으로 만들기
                Union(ob.v1, ob.v2);
            }
        }
        System.out.println(answer);
    }
}
