package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0506_Princess {

    public int solution(int n, int k){
        int answer=0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i=1; i<=n; i++){
            queue.offer(i);//넣기
        }
        while (!queue.isEmpty()){
            for (int i=1; i<k; i++){
                queue.offer(queue.poll());
                //poll() : 큐의 맨 앞의 값꺼고, 값 리턴
            }
            queue.poll();//꺼냄
            if(queue.size()==1) answer= queue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0506_Princess t = new Lec0506_Princess();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();

        System.out.println(t.solution(n, k));
    }
}
