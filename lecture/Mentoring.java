package lecture;

import java.util.Scanner;

public class Mentoring {

    public int solution(int n, int m, int[][] arr){
        int answer=0;
        int cnt = 0;

        for (int i=1; i<=n; i++) { //짝
            for (int j=1; j<=n; j++) { //짝
                cnt = 0;
                for(int k=0; k<m; k++){ //m번 테스트
                    int pi=0, pj=0;
                    for(int s=0; s<n; s++){
                        if(arr[k][s]==i) pi=s;//멘토 등수
                        if(arr[k][s]==j) pj=s;//멘티 등수
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Mentoring t = new Mentoring();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[][] arr = new int[m][n];

        for (int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.println(t.solution(n, m, arr));
    }
}
