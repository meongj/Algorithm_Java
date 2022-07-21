package PG.Level1.hash;

import java.util.HashMap;
// https://school.programmers.co.kr/learn/courses/30/lessons/42576
public class PG42576_완주하지못한선수 {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        //(이름, 개수)
        // 침여자
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        for (int i = 0; i < participant.length; i++) {
            if(map.get(participant[i]) == null) map.put(participant[i], 0); //초기화
            map.put(participant[i], map.get(participant[i])+1);
        }
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.get(completion[i])-1);
        }
        for (int i = 0; i <map.size(); i++) {
            if(map.get(participant[i]) !=0 ) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG42576_완주하지못한선수 t = new PG42576_완주하지못한선수();
        String[] p = {"mislav", "stanko", "mislav", "ana"};
        String[] c = {"stanko", "ana", "mislav"};
        t.solution(p, c);
    }
}
