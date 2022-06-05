package lecture.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Lec1005_knapsack {
    static int n, m;
    static int[] dy;

    public int solution(int[] coin){
        Arrays.fill(dy, Integer.MAX_VALUE);//최대값으로 초기화
        dy[0]=0;
        for (int i=0; i<n; i++){
            for(int j=coin[i]; j<=m; j++){
                //coin 값 빼주고 최소값이면 저장
                dy[j]=Math.min(dy[j], dy[j-coin[i]]+1);
            }
        }
        return dy[m];

    }

    public static void main(String[] args) {
        Lec1005_knapsack t = new Lec1005_knapsack();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        m = kb.nextInt();//거스름돈
        dy = new int[m+1];
        System.out.println(t.solution(arr));

    }
}
