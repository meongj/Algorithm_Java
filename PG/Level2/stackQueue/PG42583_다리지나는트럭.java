package PG.Level2.stackQueue;

import java.util.LinkedList;
import java.util.Queue;
// https://school.programmers.co.kr/learn/courses/30/lessons/42583
public class PG42583_다리지나는트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int cnt = 0; // 누적 초 시간
        Queue<Integer> truck_crossing_queue = new LinkedList<Integer>();

        int crossing_weight = 0; // 누적 트럭무게
        for(int i=0; i<truck_weights.length; i++) {
            while(true) {
                if(truck_crossing_queue.isEmpty()){ // 비어있다면 넣기
                    truck_crossing_queue.add(truck_weights[i]);
                    crossing_weight += truck_weights[i];
                    cnt++;
                    break;
                }
                // 다리 건너는중
                else {
                    // 개수 체크
                    if (truck_crossing_queue.size() == bridge_length) { // 개수 초과
                        crossing_weight -= truck_crossing_queue.poll();
                    }
                    else if (truck_weights[i] + crossing_weight > weight) { // 무게 초과
                        //초과시 초기화로 건넜다고 표시
                        truck_crossing_queue.offer(0);
                        cnt++;
                    } else { // 모든 조건만족 하면
                        truck_crossing_queue.offer(truck_weights[i]);
                        cnt++;
                        crossing_weight += truck_weights[i];
                        break;
                    }
                }
            }
        }

        return cnt + bridge_length;
    }

    public static void main(String[] args) {
        PG42583_다리지나는트럭 t = new PG42583_다리지나는트럭();
        int b_l = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        t.solution(b_l, weight, truck_weights);
    }
}
