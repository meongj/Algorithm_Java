package BOJ.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.acmicpc.net/problem/11866
public class Boj11866_요세푸스 {

    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        Queue<Integer> queue = new LinkedList();
        StringBuffer answer = new StringBuffer("<");
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while(!queue.isEmpty()) {
            if (queue.size() == 1) {
                answer.append(queue.poll()).append(">");
                break;
            }
            for (int i =0 ; i < k-1; i++) {
                queue.offer(queue.poll());
            }
            answer.append(queue.poll()).append(", ");
        }

        System.out.println(answer);
    }
}
