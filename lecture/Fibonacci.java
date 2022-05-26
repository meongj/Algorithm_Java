package lecture;

import java.util.Scanner;

public class Fibonacci {

    public String solution(int n){
        String answer="";

        //처음엔 무조건 1 1 두 숫자 셋팅
        int a=1, b=1, c=2;
        answer += a +" ";
        answer += b +" ";
        answer += c +" ";
        for (int i=0; i<n-3; i++){
            a=b;
            b=c;
            c=a+b;
            if(i==n-2) answer+= c;
            else answer+= c + " ";
        }

        return answer;
    }

    public static void main(String[] args) {
        Fibonacci t = new Fibonacci();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(t.solution(n));
    }
}
