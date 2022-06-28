package PG.Level3;

import java.util.ArrayList;
import java.util.Collections;

public class PG43164_TravelRoot {

    boolean[] ch;
    ArrayList<String> answers;
    public String[] solution(String[][] tickets) {
        answers = new ArrayList<>();
        ch = new boolean[tickets.length];

        int cnt = 0; //모든 공항들르기
        dfs(cnt, "ICN", "ICN", tickets);
        Collections.sort(answers);

        return answers.get(0).split(" ");
    }

    public void dfs(int cnt, String start, String answer, String[][] tickets) {
        if(cnt == tickets.length) {
            answers.add(answer);
            return;
        }else {
            for (int i =0; i< tickets.length; i++){
                if(!ch[i] && tickets[i][0].equals(start)) {
                    ch[i] = true;
                    dfs(cnt+1, tickets[i][1], answer +" "+tickets[i][1], tickets);
                    ch[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        PG43164_TravelRoot t = new PG43164_TravelRoot();
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        System.out.println(t.solution(tickets));

    }
}
