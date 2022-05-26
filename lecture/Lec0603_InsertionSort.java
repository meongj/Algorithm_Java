package lecture;

import java.util.Scanner;

public class Lec0603_InsertionSort {

    public int[] solution(int n, int[] arr){
        for(int i=1; i<n; i++){
            int tmp=arr[i], j;
            for(j=i-1; j>=0; j--){
                if(arr[j] > tmp) arr[j+1] = arr[j];//뒤로 밈
                else break;
            }
            arr[j+1]=tmp;//j+1 위치에 삽입해야함
        }
        return arr;
    }

    public static void main(String[] args) {
        Lec0603_InsertionSort t = new Lec0603_InsertionSort();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();

        for (int x : t.solution(n, arr)) System.out.print(x + " ");
    }
}
