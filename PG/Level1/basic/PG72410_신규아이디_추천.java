package PG.Level1.basic;
// https://school.programmers.co.kr/learn/courses/30/lessons/72410
public class PG72410_신규아이디_추천 {
    // *문자열 변환문제*
    public String solution(String input){
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
          input = input.toLowerCase();
          System.out.println("1단계----->" +input);

//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
          char[] c = input.toCharArray();
          String str =  "";
          for (int i = 0; i < c.length; i++) {
              if (Character.isLowerCase(c[i]) ||
                      c[i] == '-' || c[i] == '_' || c[i] == '.'||
                      Character.isDigit(c[i])) {
                  str += String.valueOf(c[i]);
                  continue;
              }
          }
        System.out.println("2단계----->" +str);
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
        while (str.contains("..")) {
            str = str.replace("..", ".");
        }
        System.out.println("3단계----->" +str);

//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        if (str.startsWith(".")){
            str = str.substring(1, str.length());
        }
        if (str.endsWith(".")) {
            str = str.substring(0, str.length()-1);
        }
        System.out.println("4단계----->" +str);

//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        if (str.length() == 0) {
            str = "a";
        }
        System.out.println("5단계----->" +str);
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//                만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        if (str.length() >= 16) {
            str = str.substring(0, 15);
            if (str.endsWith(".")) {
                str = str.substring(0, str.length() - 1);
            }
        }
        System.out.println("6단계----->" +str);

//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        if (str.length() <= 2) {
            StringBuilder sb = new StringBuilder(str);

            char s = str.charAt(str.length()-1);
            while (sb.length() < 3) {
                sb.append(s);
            }
            str = sb.toString();
        }
        System.out.println("7단계----->" + str);

        return str;
    }
    public static void main(String[] args) {
        PG72410_신규아이디_추천 t = new PG72410_신규아이디_추천();
        String str = "...!@BaT#*..y.abcdefghijklm";
        String str2 = "z-+.^.";
        String str3 = "=.=";
        String str4 = "123_.def";
        String str5 = "abcdefghijklmn.p";

        t.solution(str2);
    }
}
