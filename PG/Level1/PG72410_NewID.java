package PG.Level1;

import java.util.Locale;

public class PG72410_NewID {

    public String solution(String input){
        //1.대->소
        input= input.toLowerCase();
        //2. 문자 제거
        String id = "";
        for(char c : input.toCharArray()){
            if(Character.isLowerCase(c) || Character.isDigit(c) ||
            c=='-' || c=='_' || c=='.') {
                id += String.valueOf(c);
            }
        }
        input = id;


        //3. 마침표 2번이상 사용 . 으로 치환
        while (input.contains("..")){
            input= input.replace("..", ".");
        }

        //4. 마침표 맨앞, 맨뒤 제거
        if(input.length() > 0){
            if(input.charAt(0)=='.') input=input.substring(1, input.length());
        }
        if(input.length() > 0) {
            if(input.charAt(input.length()-1)=='.') input=input.substring(0, input.length()-1);
        }


        //5. 빈문자열 a 로 변경
        if(input.length() == 0){
            input="a";
        }


        //6. 16자 이상 -> 15자까지만
        if(input.length() > 15){
            input = input.substring(0, 15);
            if(input.length() > 0){
                //잘랐는데 맨앞, 맨뒤 . 있다면
                if(input.charAt(input.length()-1)=='.') input=input.substring(0, input.length()-1);
            }
        }

        //7. 2자 이하라면 마지막 문자 길이=3 붙임
        if(input.length() > 0){
            StringBuilder sb = new StringBuilder(input);
            if(input.length() < 3) {
                char tmp = input.charAt(input.length()-1);
                while (sb.length() < 3){
                    sb.append(tmp);
                }
            }
            input = sb.toString();
        }


        return input;

    }

    public static void main(String[] args) {
        PG72410_NewID t = new PG72410_NewID();
        String input = "=.=";
        System.out.println(t.solution(input));
    }
}
