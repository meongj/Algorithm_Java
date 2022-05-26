package lecture;

import java.util.Scanner;

public class Lec0601_SelectionSort {

    public String solution(int n, int[] arr){
        String answer="";
        int idx, tmp;
        //1.최솟값 찾기
        for (int i=0 ; i<n ; i++){
            idx=i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[idx]){
                  idx = j;
                }
            }
            //2.맨앞으로 정렬
            tmp=arr[i];
            arr[i]=arr[idx];
            arr[idx]=tmp;
        }
        for (int i=0; i<n; i++){
            answer+=arr[i] + " ";
        }
        return answer;
    }

    public static void main(String[] args) {
        Lec0601_SelectionSort t = new Lec0601_SelectionSort();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.println(t.solution(n, arr));
    }
}
