package lecture;

import java.util.Scanner;

class OnlyNumber {

    public int solution(String str){
        int answer=0;

        for(char x : str.toCharArray()){
            if(x>=47 && x<=57) answer=answer*10+(x-48);
        }

        return answer;
    }

    public static void main(String[] args) {
        OnlyNumber t = new OnlyNumber();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(t.solution(str));
    }

}
