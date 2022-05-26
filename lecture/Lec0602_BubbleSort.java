package lecture;

import java.util.Scanner;

public class Lec0602_BubbleSort {

    public int[] solution(int n, int[] arr){
        int tmp;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        Lec0602_BubbleSort t = new Lec0602_BubbleSort();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int x : t.solution(n, arr)) System.out.print(x+" ");

    }
}
