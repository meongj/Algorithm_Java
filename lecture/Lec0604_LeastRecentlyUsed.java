package lecture;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Lec0604_LeastRecentlyUsed {

    public int[] solution(int s, int n, int[] arr){
        int[] cache = new int[s];// 캐쉬 저장
        for (int x : arr){
            int pos = -1;//hit index 위치
            for(int i=0; i<s; i++){
                if(x==cache[i]) pos=i;
            }

            if(pos==-1){ //miss -> 뒤로 한칸씩 땡김
                for(int i=s-1; i>=1; i--){
                    cache[i] = cache[i-1];
                }
            }
            else{ //hit 뒤로 한칸씩 땡김
                for(int i=pos; i>=1; i--){
                    cache[i] = cache[i-1];//자동hit삭제
                }
            }
            cache[0]=x;
        }

        return cache;
    }

    public static void main(String[] args) {
        Lec0604_LeastRecentlyUsed t = new Lec0604_LeastRecentlyUsed();
        Scanner kb = new Scanner(System.in);
        int s = kb.nextInt();
        int n = kb.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = kb.nextInt();

        for(int x : t.solution(s, n, arr)) System.out.print(x+ " ");
    }
}
