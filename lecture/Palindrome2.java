package lecture;

import java.util.Scanner;

class Palindrome2 {

    //알파벳만 모아 나머지는 replace
    public String solution(String str){
        String answer ="NO";
        str=str.toUpperCase().replaceAll("[^A-Z]","");
        String tmp = new StringBuilder(str).reverse().toString();
        if(str.equals(tmp)) answer="YES";

        return answer;
    }

    public static void main(String[] args) {
        Palindrome2 t = new Palindrome2();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(t.solution(str));

    }
}
