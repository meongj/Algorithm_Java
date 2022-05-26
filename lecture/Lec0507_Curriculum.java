package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0507_Curriculum {

    public String solution(String str, String cal){
        String answer="YES";
        Queue<Character> queue1 = new LinkedList<>();
        for (char x : str.toCharArray()) queue1.offer(x);
        for (char x : cal.toCharArray()) {
            if(queue1.contains(x)){
                if(x!=queue1.poll()) return "NO";
            }
        }

        if(!queue1.isEmpty()) return "NO";

        return answer;
    }

    public static void main(String[] args) {
        Lec0507_Curriculum t = new Lec0507_Curriculum();
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        String cal = kb.next();
        System.out.println(t.solution(str, cal));
    }
}
