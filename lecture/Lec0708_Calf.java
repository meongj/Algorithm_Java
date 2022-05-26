package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//송아지 문제 다시 풀기

public class Lec0708_Calf {
    int answer=0;
    int[] dis = {-1, 1, 5};
    int[] ch;
    Queue<Integer> q = new LinkedList<>();

    public int BFS(int s, int e){
        ch = new int[10001];
        ch[s]=1;//방문
        q.offer(s);
        int L=1;

        while (!q.isEmpty()){
            int len = q.size();//큐의 개수 첨에 고정
            for(int i=0; i<len; i++) {
                int x = q.poll();
                for (int j = 0; j < 3; j++) {
                    int nx = x + dis[j];
                    if(nx==e) return L;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Lec0708_Calf t = new Lec0708_Calf();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();//현수
        int e = kb.nextInt();//송아지
        System.out.println(t.BFS(s,e));
    }
}
