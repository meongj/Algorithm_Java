package lecture.DP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick>{
    public int s, h, w; // 넓이, 높이, 무게
    Brick(int s, int h, int w){
        this.s = s;
        this.h = h;
        this.w = w;
    }

    // 넓이 큰 -> 작은 순으로 정렬
    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}


public class Lec1004_TallestTower {
    static int[] dy;//최대 높이

    public int solution(ArrayList<Brick> arr) {
        int answer=0;
        Collections.sort(arr); //넓이 내림차순 정렬
        dy[0]=arr.get(0).h; //높이 기본값 저장
        answer=dy[0];
        for (int i=1; i<arr.size(); i++){
            int max_h=0;
            for (int j=i-1; j>=0; j--){
                if(arr.get(j).w > arr.get(i).w && dy[j]>max_h){
                    max_h=dy[j];
                }
            }
            dy[i]=max_h+arr.get(i).h;
            answer=Math.max(answer, dy[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec1004_TallestTower t = new Lec1004_TallestTower();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Brick(a, b, c));
        }
        dy = new int[n];
        System.out.println(t.solution(arr));
    }
}
