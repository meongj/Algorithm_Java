package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec0610_Stall {

    //2. 결정 알고리즘, 유효한지 확인
    public int count(int[] arr, int dist){
        int cnt=1; //말수
        int ep=arr[0]; // 전 마구간위치
        //dist 에 따른 말의 개수체크
        for(int i=1; i<arr.length; i++){
            if(arr[i]-ep>=dist){
                cnt++;
                ep=arr[i];
            }
        }
        return cnt;
    }

    public int solution(int n, int c, int[] arr){
        int answer=0;
        //1. 좌표 정렬
        Arrays.sort(arr);
        int lt=1;
        int rt=arr[n-1];
        while (lt<=rt){
            int mid = (lt+rt)/2;
            if(count(arr, mid)>=c) {
                answer=mid;
                lt=mid+1;
            }
            else{
                rt=mid-1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0610_Stall t = new Lec0610_Stall();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int c = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();

        System.out.println(t.solution(n, c, arr));
    }
}
