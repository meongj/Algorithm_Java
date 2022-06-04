package lecture.Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge0908 implements Comparable<Edge0908>{
    public int vex; //간선
    public int cost; //비용
    Edge0908(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge0908 o) {
        //비용 오름차순 정렬
        return this.cost-o.cost;
    }
}

public class Lec0908_PriorityQueue {

    public static void main(String[] args) {
        Lec0908_PriorityQueue t = new Lec0908_PriorityQueue();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        ArrayList<ArrayList<Edge0908>> graph = new ArrayList<ArrayList<Edge0908>>();
        for (int i=0; i<=n; i++){
            graph.add(new ArrayList<Edge0908>());
        }
        int[] ch = new int[n+1]; //방문한 체크 배열
        for (int i=0; i<m; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            //양방향 그래프라 두번 넣음
            graph.get(a).add(new Edge0908(b, c));
            graph.get(b).add(new Edge0908(a, c));
        }
        int answer =0;
        PriorityQueue<Edge0908> pQ = new PriorityQueue<>();
        pQ.offer(new Edge0908(1, 0));
        while (!pQ.isEmpty()){
            Edge0908 tmp = pQ.poll();
            int ev = tmp.vex;
            if(ch[ev]==0){
                ch[ev]=1;
                answer+=tmp.cost;
                for (Edge0908 ob : graph.get(ev)){
                    if(ch[ob.vex]==0) pQ.offer(new Edge0908(ob.vex, ob.cost));
                }
            }
        }
        System.out.println(answer);

    }
}
