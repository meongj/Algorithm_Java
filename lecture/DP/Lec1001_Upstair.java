package lecture.DP;

import lecture.Greedy.Lec0606_DisjointSet;

import java.util.Scanner;

public class Lec1001_Upstair {
    static int[] dy;
    public int solution(int n) {
        dy[1]=1;
        dy[2]=2;
        for (int i=3; i<=n; i++){
            dy[i]=dy[i-2]+dy[i-1];
        }
        return dy[n];
    }

    public static void main(String[] args) {
        Lec1001_Upstair t = new Lec1001_Upstair();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n+1]; //1 ~ n번까지
        System.out.println(t.solution(n));
    }
}
