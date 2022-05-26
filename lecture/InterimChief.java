package lecture;

import java.util.Scanner;

public class InterimChief {

    public int solution(int n, int[][] arr){
        int answer=0;
        int max=Integer.MIN_VALUE;//max
        int cnt=0;
        int tmp=0;

        for (int i=1; i<=n; i++){
            cnt=0;
            for (int j=1; j<=n; j++){
                for(int k=1; k<=5; k++){
                    if(arr[i][k]==arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max) {
                max=cnt;
                answer=i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        InterimChief t = new InterimChief();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int [][] arr = new int[n+1][6];

        for (int i=1; i <= n ;i++){
            for (int j=1; j <= 5 ;j++){
                arr[i][j]= kb.nextInt();
            }
        }

        System.out.println(t.solution(n, arr));
    }
}
