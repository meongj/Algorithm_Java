package lecture.dfs;

public class Lec0801_합이같은부분집합 {

    static String answer = "NO";
    static int n, total=0;
    boolean flag = false;

    // 부분집합 => (total-sum) == sum
    public void dfs(int L, int sum, int[] arr) {
        if(flag) return;
        if(sum/2 > total) return;

        if(L == n) {
            if((total-sum)==sum) {
                answer="YES";
                flag=true;
            }
        }else {
                dfs(L+1,sum+arr[L], arr);
                dfs(L+1, sum, arr);
        }
    }


    public static void main(String[] args) {
        Lec0801_합이같은부분집합 t = new Lec0801_합이같은부분집합();
        int[] arr = {1, 3, 5, 6, 7, 10};
        n = 6;
        for (int i=0; i<n; i++) {
            total+=arr[i];
        }

        System.out.println(answer);

    }
}
