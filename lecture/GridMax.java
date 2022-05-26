package lecture;

import java.util.Scanner;

public class GridMax {

    public int solution(int n, int[][] arr){
        int max = Integer.MIN_VALUE;
        int sum1, sum2;

        //행의 합, 열의 합
        for (int i=0; i < n; i++){
            sum1=0; sum2=0;
            for(int j=0; j < n; j++){
                sum1+=arr[i][j];
                sum2+=arr[j][i];
            }
            max = Math.max(max, sum1);
            max = Math.max(max, sum2);
        }

        sum1=sum2=0;
        //대각선의 합
        for (int i=0; i < n; i++){
            sum1+=arr[i][i];
            sum2+=arr[i][n-i-1];
        }

        max = Math.max(max, sum1);
        max = Math.max(max, sum2);

        return max;
    }

    public static void main(String[] args) {
        GridMax t = new GridMax();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[][] arr = new int[n][n];

        for (int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(t.solution(n, arr));
    }
}
