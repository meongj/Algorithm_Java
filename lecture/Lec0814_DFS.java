package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Lec0814_DFS {
    static int n, m, len, answer=Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<location> hs, pz;//집, 피자 위치저장
    static int dx[]={-1,-1,0,1,1,1,0,-1};
    static int dy[]={0,1,1,1,0,-1,-1,-1};


    public void DFS(int L, int s){
        if(L==m) {
            int sum = 0;
            for (location h : hs) {//집 한채 마다 대응되는 피자집 거리 구함
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;//최솟값 다 합친값
            }
            answer = Math.min(answer, sum);
        }else{
            for (int i=s; i<len; i++){ //s부터 피자집 개수 전까지 뽑는다
                combi[L]=i;//피자집 위치 저장
                DFS(L+1, i+1);
            }
        }
    }



    public static void main(String[] args) {
        Lec0814_DFS t = new Lec0814_DFS();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        int[][] arr = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                int tmp = kb.nextInt();
                if(tmp==1) hs.add(new location(i, j));//집 위치 저장
                else if(tmp==2) pz.add(new location(i, j));// 피자 위치 저장
            }
        }
        len = pz.size();//피자집 개수
        combi = new int[m];//피자집 m개만 선택된 애들
        //구하고 싶은것? lenCm (피자집 len개수중 m개만 고르고 싶어)
        t.DFS(0,0);

        System.out.println(answer);
    }
}
