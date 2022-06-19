package PG.Level2;

import java.util.Stack;

public class PG60058_Bracket {

    public String solution(String p) {
        String answer = dfs(p);
        return answer;
    }

    public static String dfs(String s){
        //1. 빈문자열 -> 빈문자열 반환
        if (s == "") return "";
        //2. 균형잡힌 괄호 인지 확인
        int lcnt = 0;
        int rcnt = 0;
        String u = "";
        String v = "";
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') lcnt++;
            else rcnt++;
            u += s.charAt(i);
            if(lcnt==rcnt){
                v = s.substring(i+1);
                break;
            }
        }
        //3. u가 올바른 문자열인지 확인
        if(isCorrect(u)) return u += dfs(v);
        //4. u가 올바른 문자열이 아니면
        else{
            String tmp = "(";
            tmp += dfs(v);
            tmp += ")";
            u = u.substring(1, u.length()-1);

            //뒤집기
            for (int i=0; i<u.length(); i++){
                if(u.charAt(i) == '(') tmp += ')';
                else tmp += '(';
            }
            return tmp;
        }

    }

    public static boolean isCorrect(String s){
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push('(');
            }else{
                    if (stack.isEmpty() || stack.peek() == ')') { // )) 일경우
                        return false;
                    } else stack.pop();
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PG60058_Bracket t = new PG60058_Bracket();
        String s = ")(";
        System.out.println(t.solution(s));
    }
}
