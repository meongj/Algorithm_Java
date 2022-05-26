package lecture;

import java.util.Scanner;

public class Maximum {

    public int solution(int n, int k, int[] arr){
        //Sliding window : 창문처럼 한칸씩 옆으로 민다
        int sum =0, max = Integer.MIN_VALUE;

        for(int i=0; i<k; i++){
            sum += arr[i];
        }
        max = sum;

        for (int i=k; i<n; i++){
            sum +=(arr[i]-arr[i-k]);
            max=Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        Maximum t = new Maximum();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.print(t.solution(n, k, arr));
    }
}
