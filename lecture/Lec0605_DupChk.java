package lecture;

import java.util.*;

public class Lec0605_DupChk {

    public String solution(int n, int[] arr){
        String answer="U";
        //1.오름차순 정렬
        Arrays.sort(arr);
        //2.이웃숫자 중복된 것 있는지 확인
        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]) return "D";
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0605_DupChk t = new Lec0605_DupChk();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= kb.nextInt();
        }

        System.out.println(t.solution(n, arr));
    }
}
