package lecture;

import java.util.Scanner;

public class ConsecutiveNumbers {

    public int solution(int n){
        int answer=0;
        int lt=0, sum=0;
        int m=n/2+1;
        int[] arr = new int[m];
        for(int i=0; i<m; i++) arr[i]=i+1;

        // 투포인터로 누적합산
        for(int rt=0; rt<m; rt++){
            sum+=arr[rt];
            if(sum==n) answer++;
            while(sum>=n) {
                sum -= arr[lt++];
                if (sum == n) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ConsecutiveNumbers t = new ConsecutiveNumbers();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();

        System.out.println(t.solution(n));
    }
}
