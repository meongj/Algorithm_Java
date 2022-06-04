package lecture.DP;

import java.util.Scanner;

public class Lec1003_IncreasingSeq {
    static int[] dy;
    public static int solution(int[] arr) {
        int answer=0;
        dy=new int[arr.length];
        dy[0]=1;
        for (int i=1; i<arr.length; i++){
            int max=0;
            for(int j=i-1; j>=0; j--){
                //1.arr[i] 보다 작은 값들 중 max 값 찾기
                if(arr[j] < arr[i] && dy[j] > max) max=dy[j];
            }
            //2. 최대부분증가값 저장
            dy[i]=max+1;
            //3. 증가값 중 최대값 찾기
            answer=Math.max(answer, dy[i]);
        }
        return answer;
    }

        public static void main(String[] args) {
        Lec1003_IncreasingSeq t = new Lec1003_IncreasingSeq();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++){
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(arr));
    }
}
