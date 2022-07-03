package lecture.dfs;

import java.util.Scanner;

public class Lec0805_동전교환 {

    static int n, m;
    static int min = Integer.MAX_VALUE; // 최소동전개수
    public void dfs(int L, int sum, int[] arr) {
        if(sum > m) return;
        if (sum == m) {
            min = Math.min(L, min);
            return;
        }else{
            for (int i=0; i<arr.length; i++) {
                dfs(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        Lec0805_동전교환 t = new Lec0805_동전교환();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        int[] arr = new int[n]; // 동전저장
        for (int i=0; i<n; i++){
            arr[i]=kb.nextInt();
        }
        m = kb.nextInt();
        t.dfs(0,0, arr);
        System.out.println(min);
    }
}
