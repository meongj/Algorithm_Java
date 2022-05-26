package lecture;

import java.util.Scanner;

class FlipWords2 {

    /*
    영어 알파벳만 뒤집고
    특수문자는 그대로 출력
     */
    public String solution(String str){
        String answer = "";
        char[] s = str.toCharArray();

        int lt =0, rt = str.length()-1;

        while (lt<rt){

            /*
            둘다 알파벳이면 뒤집고
            둘다 특수문자면 x
             */
            if(!Character.isAlphabetic(s[lt])){ //알파벳이면 참, 아니면 특수문자로 간주
                lt++;
            }else if(!Character.isAlphabetic(s[rt])){
                rt--;
            }else{//알파벳인 경우 뒤집기
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }

        answer=String.valueOf(s);//char[] -> string 변환

        return answer;
    }

    public static void main(String[] args) {
        FlipWords2 t = new FlipWords2();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(t.solution(str));

    }
}
