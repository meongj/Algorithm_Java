package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Boj10773_Zero {

    public int solution(int k, int[] arr){
        int sum=0;
        Stack<Integer> stack = new Stack<>();
        for (int x : arr){
            if(x==0) {
                stack.pop();
            }
            else {
                stack.add(x);
            }
        }
        while (!stack.isEmpty()){
            sum+=stack.pop();
        }

        return sum;
    }

    public static void main(String[] args) {
        Boj10773_Zero t = new Boj10773_Zero();
        Scanner kb = new Scanner(System.in);
        int k = kb.nextInt();
        int[] arr = new int[k];
        for (int i=0; i<k; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(k,arr));
    }
}
