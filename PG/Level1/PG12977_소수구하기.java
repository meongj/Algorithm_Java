package PG.Level1;
// https://school.programmers.co.kr/learn/courses/30/lessons/12977
public class PG12977_소수구하기 {

    public int solution(int[] nums) {
        int cnt  = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum  = nums[i] + nums[j] + nums[k];
                        // 소수 인지 체크
                        cnt += isDecimal(sum);
                    }
                }
        }
        return cnt;
    }

    public int isDecimal(int sum) {
        for (int m = 2; m < sum; m++) {
            if (sum % m == 0) { // 소수가 아니면
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        PG12977_소수구하기 t = new PG12977_소수구하기();
        int[] nums = {1,2,3,4};
        int[] nums2 = {1,2,7,6,4};
        t.solution(nums);
        t.solution(nums2);
    }
}
