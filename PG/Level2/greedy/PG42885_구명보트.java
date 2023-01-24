package PG.Level2.greedy;

import java.util.Arrays;
// https://school.programmers.co.kr/learn/courses/30/lessons/42885
public class PG42885_구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int j = 0;
        // 최대한 큰 것부터 담는다
        // 큰수 부터 정렬 (내림차순)
        //Arrays.sort(people, Collections.reverseOrder()); // people type=Integer 가능
        // 오른차순 정렬
        Arrays.sort(people);
        for (int i = people.length - 1; i >=0 ; i--) {
            if (people[i] == 0) continue;
            // 큰 몸무게와 작은 몸무게를 같이 싣는다
            if (people[i]+people[j] <= limit) {
                people[j] = 0; // 싣으면 0으로
                j++;
            }
            answer++; // limit 넘을경우
        }

        return answer;
    }

    public static void main(String[] args) {
        PG42885_구명보트 t = new PG42885_구명보트();
        int[] people = {70, 50, 80, 50};
        int limit = 100;
        System.out.println( t.solution(people, limit));
    }
}
