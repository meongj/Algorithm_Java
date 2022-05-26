package lecture;

import java.util.Scanner;

public class MaximumLength {

    public int solution(int n, int k, int[] arr){
        int answer=0;
        int cnt=0, lt=0;

        for(int rt=0; rt<n; rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>k){//바꾼지점 조정먼저, k보다 크면 안되기 때문 다시 원래대로 돌려놓음
                if(arr[lt]==0) cnt--;//0->1로 바꾼지점 다시 원래대로
                //실제로 0->1로 바꾸지 않는다, 그저 count만 셀뿐...
                lt++;//범위 변경
            }
            //rt-lt+1 = 연속된 길이
            answer=Math.max(answer, rt-lt+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        MaximumLength t = new MaximumLength();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr = new int[n];
        for(int i =0; i<n; i++){
            arr[i] = kb.nextInt();
        }

        System.out.print(t.solution(n, k, arr));
    }
}
