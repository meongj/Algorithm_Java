package lecture;

import java.util.Scanner;

public class Password {
    /*
    1. 문자-> 숫자 변환
        # : 이진수의 1
        * : 이진수의 0
    2. 2진수 -> 10진수
    3. 아스키 번호 -> 대문자 변환
       (A=65, B=66, C=67 ... Z=90)
     */

    public String solution(int n, String str){
        String answer="";

            for (int i = 0; i < n; i++) {
                String tmp = str.substring(0, 7).replace('#', '1').replace('*','0');
                int num = Integer.parseInt(tmp, 2); //2진수를 10진수로 변환
                answer+=(char)num;//문자로 변환
                str= str.substring(7);
            }

        return answer;
    }

    public static void main(String[] args) {
        Password t = new Password();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();

        System.out.println(t.solution(n, str));
    }
}
