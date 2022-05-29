package BOJ.Greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

//(x=절대값, y=원래값)
//절대값 기준 오름차순 정렬
class Point implements Comparable<Point>{
    int x;
    int y;
    Point(int x, int y){
        this.x = x;
        this.y =y;
    }

    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;
        return this.x - o.x;
    }
}

public class Boj11286_AbsoluteValue {


    public static void main(String[] args) {
        Boj11286_AbsoluteValue t = new Boj11286_AbsoluteValue();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        PriorityQueue<Point> pQ = new PriorityQueue<>();//작은 것부터 정렬

        for (int i=0; i<n; i++){
            int val = kb.nextInt();
            if(val==0){ //0 미포함
                if(!pQ.isEmpty()){
                    System.out.println(pQ.poll().y);
                }else{
                    System.out.println(0);
                }
            }else {
                pQ.offer(new Point(Math.abs(val), val)); // 절대값 기준 정렬
            }

        }

        }
}
