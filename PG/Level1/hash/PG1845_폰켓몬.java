package PG.Level1.hash;

import java.util.HashSet;
// https://school.programmers.co.kr/learn/courses/30/lessons/1845
public class PG1845_폰켓몬 {

    public int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2; //가장 많은 종류
        HashSet<Integer> set = new HashSet<>();
        // 중복제거
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //폰켓몬 최대선택
        if(set.size() > max) answer = max; //범위안에
        else answer = set.size();

        return answer;
    }

    public static void main(String[] args) {
        PG1845_폰켓몬 t = new PG1845_폰켓몬();
        int[] nums1 = {3,1,2,3};
        int[] nums2 = {3,3,3,2,2,4};
        int[] nums3 = {3,3,3,2,2,2};
        System.out.println(t.solution(nums1));
        System.out.println(t.solution(nums2));
        System.out.println(t.solution(nums3));
    }

}
