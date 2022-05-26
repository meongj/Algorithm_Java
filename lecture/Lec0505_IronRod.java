package lecture;

import java.util.Scanner;
import java.util.Stack;

public class Lec0505_IronRod {

    public int solution(String str){
        int answer=0;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++){
            if(str.charAt(i)=='(') stack.push('(');
            else { // ')'
                stack.pop();
                //레이저인지 확인
                if(str.charAt(i-1) == '(') answer+=stack.size();//레이저이면 ( 개수 누적
                else answer++; //막대기 끝 +1 추가
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Lec0505_IronRod t = new Lec0505_IronRod();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(t.solution(str));
    }
}
