package lecture;

import java.util.Arrays;
import java.util.Scanner;


class Lec0609_MusicVideo {

    //DVD 용량 대비 가능한 누적count
    public int count(int[] arr, int capacity){
        int cnt=1, sum=0;
        for(int x : arr){
            if(sum+x > capacity){
                cnt++;
                sum=x;
            }
            else sum+=x;
        }
        return cnt;
    }

    public int solution(int n, int m, int[] arr){
        int answer=0;
        int lt= Arrays.stream(arr).max().getAsInt();//최댓값 가져오기
        int rt= Arrays.stream(arr).sum();//모든 값의 합

        while(lt<=rt){
            int mid=(lt+rt)/2;
            if(count(arr, mid) <= m){
                answer=mid;
                rt=mid-1;
            }
            else lt=mid+1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Lec0609_MusicVideo t = new Lec0609_MusicVideo();
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
