package lecture;

import java.util.Scanner;

public class Tallest {
    /*
    N명 학생 일렬 정렬
    앞의 모든 학생들보다 큰 키가진 학생 수 출력
    (키가 같아도 안보인다)
     */

    public int solution(int n, int[] arr){
        int answer=1; //첫번째 학생은 무조건 보임
        int max= arr[0];

        for(int i=1; i<n; i++){
            if (arr[i] > max){
                answer++;
                max=arr[i];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Tallest t = new Tallest();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n ;i++)
            arr[i]=kb.nextInt();

        System.out.println(t.solution(n, arr));
    }
}
