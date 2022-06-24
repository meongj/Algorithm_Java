package PG.Level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class PG42587_Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        // 큰 -> 작 순서대로 저장
        Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<priorities.length; i++){
            q.add(priorities[i]);
        }

        while (!q.isEmpty()){
            for (int i=0; i<priorities.length; i++){
                if(priorities[i] == q.peek()){
                    // 같은 값이고
                    if(i == location){
                        // 위치도 같으면 찾음
                        answer++;
                        return answer;
                    }
                    q.poll();
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PG42587_Printer t = new PG42587_Printer();
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(t.solution(priorities, location));
    }
}
