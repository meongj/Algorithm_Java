package lecture;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {

    public int solution(String str){
        int answer=0;
        Stack<Integer> stack = new Stack();

        for(char s : str.toCharArray()){
            if(Character.isDigit(s)) {
                stack.push(s - 48);
            }else{
                int rt = stack.pop();
                int lt = stack.pop();
                if(s == '+') stack.push(lt+rt);
                else if(s == '-') stack.push(lt-rt);
                else if(s == '*') stack.push(lt*rt);
                else stack.push(lt/rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Postfix t = new Postfix();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();

        System.out.println(t.solution(str));
    }
}
