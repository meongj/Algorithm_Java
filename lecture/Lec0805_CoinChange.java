package lecture;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Lec0805_CoinChange {
    static int n, m, min=Integer.MAX_VALUE;

    public void BFS(int L, int sum, Integer[] coin){
        if(sum>m) return;
        if(L>=min) return;
        if(sum==m){
            min = Math.min(min, L);
            return;
        }else{
            for(int i=0; i<n; i++) {
                BFS(L + 1, sum + coin[i], coin);
            }
        }
    }

    public static void main(String[] args) {
        Lec0805_CoinChange t = new Lec0805_CoinChange();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] coin = new Integer[n];
        for(int i=0; i<n; i++){
            coin[i]=kb.nextInt();
        }
        m = kb.nextInt();
        //큰 금액부터 비교하면 빨리 답을 찾을수있다
        // 내림차순 정렬
        Arrays.sort(coin, Collections.reverseOrder());
        t.BFS(0, 0,coin);
        System.out.println(min);
    }
}

