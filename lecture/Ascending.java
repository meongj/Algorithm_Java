package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Ascending {

    public ArrayList<Integer> solution(int n, int m, int[] arr, int[] arr2){
        ArrayList<Integer> answer= new ArrayList<>();
        int p1=0, p2=0; // 투포인터

        while(p1<n && p2<m){
            if(arr[p1] < arr2[p2]) answer.add(arr[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1<n) answer.add(arr[p1++]);
        while (p2<m) answer.add(arr2[p2++]);

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
