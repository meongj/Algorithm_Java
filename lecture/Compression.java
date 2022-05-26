package lecture;

import java.util.Scanner;

class Compression {

    public String solution(String str){
        String answer="";
        str=str+" ";//indexOutofBound error 방지를 위한 빈문자열 추가

        int cnt=1;
        for(int i=0; i< str.length()-1; i++){
            if(str.charAt(i)== str.charAt(i+1)) cnt++;
            else{
                answer+= str.charAt(i);
                if(cnt>1) answer+=String.valueOf(cnt);
                cnt=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Compression t = new Compression();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(t.solution(str));
    }
}
