package BOJ.Basic;

import java.util.*;
// https://www.acmicpc.net/problem/11650
class Coodinate implements Comparable<Coodinate> {
    int x, y;

    Coodinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Coodinate o) { // x축 정렬
        if (this.x == o.x) return this.y - o.y;
        else return this.x - o.x;
    }
}


public class Boj11650_좌표정렬하기 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Coodinate> arr = new ArrayList<Coodinate>();

        for (int i = 0; i < n; i++) {
            int x = kb.nextInt();
            int y = kb.nextInt();
            arr.add(new Coodinate(x, y));
        }
        Collections.sort(arr);
        // x축 기준 정렬
        for (int i = 0; i < n; i++) {
            System.out.println(arr.get(i).x + " " + arr.get(i).y);
        }

        }
}
