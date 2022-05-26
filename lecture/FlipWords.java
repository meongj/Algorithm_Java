package lecture;

import java.util.ArrayList;
import java.util.Scanner;

class FlipWords {

    public ArrayList<String> solution(int num, String[] str){
        ArrayList<String> answer = new ArrayList<>();

       for(String x : str) {
           char[] s = x.toCharArray();
           int lt =0, rt=x.length()-1;
           while (lt<rt) {
               char tmp = s[lt];
               s[lt]=s[rt];
               s[rt]=tmp;
               lt++;
               rt--;
           }
           String tmp= String.valueOf(s);//string으로 변환
           answer.add(tmp);
       }

        return answer;
    }

    public static void main(String[] args) {
        FlipWords T = new FlipWords();
        Scanner kb = new Scanner(System.in);
        int num = kb.nextInt();

        String[] str = new String[num];

        for (int i=0; i<num ; i++){
            str[i] = kb.next();
        }
        for(String x : T.solution(num, str)){
            System.out.println(x);
        }

    }
}
