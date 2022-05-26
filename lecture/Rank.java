package lecture;

import java.util.Scanner;

public class Rank {

    public int[] solution(int n, int[] arr){
        int[] ch = new int[n];//큰수있는지 체크 (1: default)

        for (int i=0; i<n; i++){
            ch[i]=1;
            for (int j=0; j<n; j++) {
                if (arr[i] < arr[j]) ch[i]++;
            }
        }

        return ch;
    }

    public static void main(String[] args) {
        Rank t = new Rank();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        for(int res : t.solution(n, arr))
            System.out.print(res + " ");
    }
}
