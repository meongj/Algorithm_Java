package lecture.Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge>{
    public int vex;// 끝 정점
    public int cost;//간선 가중치값
    Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        //가장 작은 값 우선(오름차순)
        return this.cost-o.cost;
    }
}


public class Lec0905_Dijkstra {
    static int n, m;//정점개수, 간선개수
    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;// 0-> 간선 최소거리 저장

    public void solution(int v) {
        //cost기준이 가장 작은 값으로 꺼내고 비교
        PriorityQueue<Edge> pQ = new PriorityQueue<>();
        pQ.offer(new Edge(v, 0)); // 1부터 시작, 비용은 0
        dis[v]=0;
        while (!pQ.isEmpty()){
            Edge tmp = pQ.poll();
            int now = tmp.vex; //정점
            int nowCost = tmp.cost; //간선의 가중치
            if(nowCost > dis[now]) continue; //작은 값 찾아야함
            for (Edge ob : graph.get(now)){
                if(dis[ob.vex] > nowCost+ ob.cost) {
                    dis[ob.vex]=nowCost+ob.cost;
                    pQ.offer(new Edge(ob.vex, nowCost+ob.cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Lec0905_Dijkstra t = new Lec0905_Dijkstra();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        graph = new ArrayList<ArrayList<Edge>>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge>());
        }
        dis=new int[n+1];
        //Arrays.fill(2차원배열, 초기화할 값) : 2차원 배열 초기화
        Arrays.fill(dis, Integer.MAX_VALUE);
        for (int i=0; i<m; i++){
            int a = kb.nextInt();//끝 정점
            int b= kb.nextInt(); //가중치 값
            graph.get(a).add(new Edge(a, b));
        }
        t.solution(1); //정점1부터 시작
        for (int i=2; i<=n; i++){
            if(dis[i] != Integer.MAX_VALUE) System.out.println(i+" : "+dis[i]);
            else System.out.println(i+" : impossible");
        }

    }
}
