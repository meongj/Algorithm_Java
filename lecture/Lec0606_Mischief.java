package lecture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Lec0606_Mischief {

    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        int[] tmp = arr.clone();//복사
        Arrays.sort(tmp);//정렬

        for(int i=0; i<n; i++){
            if(arr[i] != tmp[i]) answer.add(i+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0606_Mischief t = new Lec0606_Mischief();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for (int x :t.solution(n, arr)) System.out.print(x + " ");
    }
}
