package lecture.dfs;

import java.util.Collection;

public class Lec0802_바둑이승차 {

    static int c = 259;
    static int n = 5;
    static int max = Integer.MIN_VALUE;

    //바둑이 태운다 or 태우지 않는다
    //D(L, sum-트럭에 타는 바둑이무게)
    public void dfs(int L, int sum, int[] arr) {

        if(sum > c) return;

        if(L == n) {
            //마지막체크
            max=Math.max(max, sum);
            return;
        }else {
            if(sum > max) max=sum;

                dfs(L+1, sum+arr[L], arr);
                dfs(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        Lec0802_바둑이승차 t = new Lec0802_바둑이승차();
        int[] arr = {81, 58, 42, 33, 61};

        t.dfs(0, 0, arr);
        System.out.println(max);

    }
}
