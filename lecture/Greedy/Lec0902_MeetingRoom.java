package lecture.Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    Meeting (int start, int end){
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        if(o.end == this.end) return this.start - o.start;
        else return this.end - o.end;
    }
}

public class Lec0902_MeetingRoom {
    /*
    02. 회의실
    - 회의가 빨리 끝나는 것부터 선택해야 함, 끝나는 시간 오름차순 정렬
    - 끝나는 시간 같으면, 시작시간 오름차순 정렬
     */

    public int solution(ArrayList<Meeting> arr, int n){
        int cnt=0;
        Collections.sort(arr);
        int et = 0;
        for (Meeting ob : arr){
            if(ob.start >= et){
                cnt++;
                et=ob.end;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Lec0902_MeetingRoom t = new Lec0902_MeetingRoom();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Meeting> arr = new ArrayList<Meeting>();
        for(int i=0; i<n; i++){
            int start= kb.nextInt();
            int end = kb.nextInt();
            arr.add(new Meeting(start, end));
        }
        System.out.println(t.solution(arr, n));

    }

}
