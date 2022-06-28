package PG.Level3;

public class PG43162_Network {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int ch[] = new int[n];

        for (int i=0; i<n; i++) {
                if(ch[i] == 0) {
                    answer++;
                    ch[i]=1;
                    dfs(i, ch, computers);
                }
        }

        return answer;
    }

    public void dfs(int L, int[] ch, int[][] computers) {
        if(L == computers.length){
            return;
        }else {
            for (int i = 0; i < computers.length; i++) {
                if (ch[i] == 0 && computers[L][i] == 1) {
                    ch[i] = 1;
                    dfs(i, ch, computers);
                }
            }
        }
    }

    public static void main(String[] args) {
        PG43162_Network t = new PG43162_Network();
        int n = 3;
        int[][] computers = new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(t.solution(n, computers));
    }
}
