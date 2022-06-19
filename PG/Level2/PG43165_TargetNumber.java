package PG.Level2;

public class PG43165_TargetNumber {

    int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    public void dfs(int[] numbers, int depth, int target, int sum){
        if(depth == numbers.length){//마지막 이면
            if(sum == target) answer++;
        }else {
            dfs(numbers, depth+1, target, sum + numbers[depth]);
            dfs(numbers, depth+1, target, sum - numbers[depth]);
        }
    }

    public static void main(String[] args) {
        PG43165_TargetNumber t = new PG43165_TargetNumber();
        int[] input = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(t.solution(input, target));
    }
}
