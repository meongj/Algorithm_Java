package lecture;

import java.util.Scanner;

class CaseConversion {

    /*
    문자열 대문자 -> 소문자
          소문자 -> 대문자
     */

    public String solution(String str){
        String answer = "";

        for (char x : str.toCharArray()) {
            if (Character.isUpperCase(x))
                answer += Character.toLowerCase(x);
            else if (Character.isLowerCase(x))
                answer += Character.toUpperCase(x);
        }

        return answer;
    }

    public static void main(String[] args) {
        CaseConversion T = new CaseConversion();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(T.solution(str));

    }
}
