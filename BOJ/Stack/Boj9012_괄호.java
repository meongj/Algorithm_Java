package BOJ.Stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class Boj9012_괄호 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        Stack<Character> stack;
        for (int i = 0; i < t; i++) {
            String answer = "YES";
            String s = kb.next();
            stack = new Stack<Character>();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') {
                    stack.push('(');
                } else if (s.charAt(j) == ')') {
                    if(stack.isEmpty()) {
                        answer = "NO";
                        break;
                    }
                    stack.pop();
                }
            }
            if (!stack.isEmpty()) answer = "NO";
            System.out.println(answer);
        }
    }
}
