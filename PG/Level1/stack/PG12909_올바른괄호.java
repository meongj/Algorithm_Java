package PG.Level1.stack;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=java
public class PG12909_올바른괄호 {

    boolean solution(String s) {
        boolean answer = true;

        char[] charray = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();


            for (int i = 0; i < charray.length; i++) {
                if (charray[i] == '('){
                    stack.push('(');
                } else { // )
                    if (stack.isEmpty()) return false;
                    stack.pop();
                }
            }
            if(!stack.isEmpty()) return false;


        return answer;
    }

    public static void main(String[] args) {
        PG12909_올바른괄호 t = new PG12909_올바른괄호();
        System.out.println(t.solution("()()"));
        System.out.println(t.solution("(())()"));
        System.out.println(t.solution(")()("));
        System.out.println(t.solution("(()("));


    }
}
