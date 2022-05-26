package lecture;

import java.util.Scanner;

class Palindrome {

    //앞에서 읽는것, 뒤에서 읽는 것이 같은 문자열 = 회문문자열
    public String solution(String str){
        String answer ="YES";
        str = str.toUpperCase();
        int len =str.length();

        for(int i=0; i<len/2; i++){
            if(str.charAt(i)!=str.charAt(len-i-1)) return "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Palindrome t = new Palindrome();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(t.solution(str));

    }
}
