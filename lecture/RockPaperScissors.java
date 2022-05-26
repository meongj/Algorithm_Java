package lecture;

import java.util.Scanner;

public class RockPaperScissors {

    public String solution(int a, int b){
        String answer="";

        if(a==1 && b==3 || (a==2 && b==1) || (a==3 && b==2)) answer="A";
        else if(a==b) answer="D";
        else answer="B";

        return answer;
    }

    public static void main(String[] args) {
        RockPaperScissors t = new RockPaperScissors();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i=0; i<n; i++)
            a[i] = kb.nextInt();

        for (int i=0; i<n; i++)
            b[i] = kb.nextInt();

        for (int i=0; i<n; i++)
            System.out.println(t.solution(a[i], b[i]));

    }
}
