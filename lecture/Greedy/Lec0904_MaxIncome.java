package lecture.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class schedule implements Comparable<schedule>{
    int income;
    int day;
    schedule(int income, int day){
        this.income = income;
        this.day = day;
    }

    @Override
    public int compareTo(schedule o) {
        //수입 오름차순 정렬
        return o.income-this.income;
    }
}
/*
04. 우선순위 큐
- 수입 오름차순 정렬
- day3 ~ day1 까지 list에 차례로 수입 넣는다
- day3 일때 수입 넣고 최대수익인 것 꺼내서 저장한다
- day2 일때 수입 넣고 ...
.. 반복후
-> 저장한 최대 수익 출력
 */

public class Lec0904_MaxIncome {
    static int n, max=Integer.MIN_VALUE;
    public int solution(ArrayList<schedule> arr){
        int answer=0; //최대 수익
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arr);//날짜 큰것부터 정렬
        int j=0;
        for(int i=max; i>=1; i--){
            for ( ; j<n; j++){
                if(arr.get(j).day < i) break;//day3일때..day2..day1...
                pQ.offer(arr.get(j).income);//강연료 넣기
            }
            if(!pQ.isEmpty()){ //day 하루씩마다 체크해서 하루에 최대수익 꺼냄
                answer+=pQ.poll();//가장 큰 값 꺼내기
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Lec0904_MaxIncome t = new Lec0904_MaxIncome();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        ArrayList<schedule> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int income = kb.nextInt();
            int day = kb.nextInt();
            arr.add(new schedule(income, day));
            //최대 day 날짜 구하기
            if(day > max) max= day;
        }
        System.out.println(t.solution(arr));

    }
}
