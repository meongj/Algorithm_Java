package BOJ;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SumTwoNum {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        int x = kb.nextInt();

        int answer=0;
        int lt=0, rt=n-1, sum=0;

        //오름차순 정렬(작->큰)
        Arrays.sort(arr);

        while(lt<rt) {
            sum = arr[rt] + arr[lt];

            if (sum == x) {
                answer++;
            }

            if (sum <= x) lt++;
            else rt--;

            sum=0;
        }


        System.out.print(answer);
    }
}
