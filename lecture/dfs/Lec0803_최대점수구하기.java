package lecture.dfs;

import java.util.ArrayList;
import java.util.Scanner;

class Jumsu {
    int score;
    int time;
    public Jumsu(int score, int time) {
        this.score = score;
        this.time = time;
    }
}

public class Lec0803_최대점수구하기 {

    static int n, m, max = Integer.MIN_VALUE; // 점수
    static ArrayList<Jumsu> arr;
    static boolean flag = false;

    // 점수기준
    public void dfs(int L, int time_sum, int score_sum) {

        if(flag) return;
        if(time_sum > m) return;
        if (L == n) {
            max = Math.max(max, score_sum);
            flag= true;
            return;
        }else {
            dfs(L+1, time_sum+arr.get(L).time, score_sum+arr.get(L).score);
            dfs(L+1, time_sum, score_sum);
        }
    }

    public static void main(String[] args) {
        Lec0803_최대점수구하기 t = new Lec0803_최대점수구하기();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();
        arr = new ArrayList<>();

        for (int i=0; i<n; i++){
            int score = kb.nextInt();
            int time = kb.nextInt();
            arr.add(new Jumsu(score, time));
        }
        t.dfs(0,0,0);
        System.out.println(max);
    }
}
