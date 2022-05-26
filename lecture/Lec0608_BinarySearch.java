package lecture;

import java.util.Arrays;
import java.util.Scanner;

public class Lec0608_BinarySearch {
    //이분 검색 알고리즘
    public int solution(int n, int m, int[] arr){
        int answer=0;
        //1. 정렬
        Arrays.sort(arr);
        //2.m 찾기
        int lt=0, rt=n-1;
        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(arr[mid]==m){
                answer=mid+1;
            }
            if(arr[mid]>m) rt=mid-1;
            else lt=mid+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0608_BinarySearch t = new Lec0608_BinarySearch();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(t.solution(n, m, arr));
    }
}
