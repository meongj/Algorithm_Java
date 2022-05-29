package lecture.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class time implements Comparable<time>{
    public int time;
    public char state; // 상태저장
    time(int time, char state){
        this.time = time;
        this.state = state;
    }

    @Override
    public int compareTo(time ob) {
        //시간이 같으면 (상태 오름차순) 정렬
        if(this.time == ob.time) return this.state-ob.state;
        //시간이 같지 않으면 (시간 오름차순) 정렬
        else return this.time-ob.time;
    }
}
/*
03. 결혼식
동시간에 최대 존재 사람count
시작시간 ++
끝시간 --
count해서 max값 구함
 */
public class Lec0903_Wedding {
    public int solution(ArrayList<time> arr){
        int count=0;
        Collections.sort(arr);//끝 시간 오름차순 정렬
        int answer = Integer.MIN_VALUE; // 끝시간 : 시작시간이 끝시간보다 커야하므로 저장
        for(time ob : arr){
            if(ob.state=='s') count++;//시작시간이면
            else count--;
            answer=Math.max(answer, count);// 최대값
        }
        return answer;
    }

    public static void main(String[] args) {
        Lec0903_Wedding t = new Lec0903_Wedding();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<time> arr = new ArrayList<>();
        for (int i=0; i<n; i++){
            int st = kb.nextInt();
            int et = kb.nextInt();
            arr.add(new time(st, 's'));//시작시간, 상태
            arr.add(new time(et, 'e'));//끝시간, 상태
        }
        System.out.println(t.solution(arr));
    }
}
