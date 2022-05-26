package lecture;

import java.util.Scanner;

class CharaterFind {

    public int solution(String str, char t){
        int answer = 0;

        //대문자로 비교
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i)==t) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        CharaterFind T = new CharaterFind();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();//문자열 받음
        char c = kb.next().charAt(0);//문자 받음

        System.out.println(T.solution(str, c));
    }
}
