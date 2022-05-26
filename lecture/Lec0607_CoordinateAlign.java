package lecture;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Point implements Comparable<Point>{
    //Comparable<Point> : Point 객체 정렬한다.
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    //정렬 기준
    @Override
    public int compareTo(Point o) {
        if(this.x == o.x) return this.y - o.y;//y 오름차순 리턴(음수)
            //내림차순  return o-y - this.y;
        else return this.x - o.x;// x 오름차순 리턴
            //내림차순  return o-x - this.x;
    }
}

class Lec0607_CoordinateAlign {

    public static void main(String[] args) {
        Lec0607_CoordinateAlign t = new Lec0607_CoordinateAlign();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);//정렬
        for (Point o : arr) System.out.println(o.x +" "+o.y);
    }
}
