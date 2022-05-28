package lecture.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Body implements Comparable<Body>{
    int height;
    int weight;
    Body (int height, int weight){
        this.height = height;
        this.weight = weight;
    }
    //키 내림차순 정렬 큰순서대로
    @Override
    public int compareTo(Body o) {
        return o.height - this.height;
    }
}
/*
그리디 알고리즘
1. 씨름선수
-> 이중 for문 time-limit X
- 먼저 키 정렬(큰순서대로), 다음 몸무게 비교
 */

public class Lec0901_Wrestling {

    public int solution(ArrayList<Body> arr, int n){
        int cnt=0;
        Collections.sort(arr);//내림차순 정렬
        int max = Integer.MIN_VALUE;
        for(Body ob: arr){
            if(ob.weight > max) {
                max = ob.weight;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lec0901_Wrestling t = new Lec0901_Wrestling();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Body> arr = new ArrayList<Body>();
        for(int i=0; i<n; i++){
            int height= kb.nextInt();
            int weight = kb.nextInt();
            arr.add(new Body(height, weight));
        }
        System.out.print(t.solution(arr, n));
    }
}
