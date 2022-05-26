package lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CommonElement {

    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2){
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int p1=0, p2=0;

        while(p1<n && p2<m){
            if(arr[p1] == arr2[p2]) {answer.add(arr[p1++]); p2++;}
            else if(arr[p1] < arr2[p2]) p1++;
            else p2++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ascending t = new Ascending();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        int m = kb.nextInt();
        int[] arr2 = new int[m];
        for (int i=0; i<m; i++){
            arr2[i] = kb.nextInt();
        }

        for(int x : t.solution(n, m, arr, arr2))
            System.out.print(x + " ");
    }
}

