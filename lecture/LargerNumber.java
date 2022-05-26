package lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class LargerNumber {

    /*
    N개 정수
    자신의 바로 앞수보다 큰 수만 출력
    (첫번째 수는 무조건 출력)
    */
    public ArrayList<Integer> solution(int n, int[] arr){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i=1; i<n; i++){
            if(arr[i] > arr[i-1]){
                answer.add(arr[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LargerNumber t = new LargerNumber();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x: t.solution(n, arr)) {
            System.out.print(x+" ");
        }
    }
}
