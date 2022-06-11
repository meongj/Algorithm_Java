package PG.Level1;

import java.util.Arrays;
import java.util.Scanner;

public class PG77484_lotto {

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeroCnt = 0; // 0의 개수
        int equalCnt = 0; // 같은 번호 개수
        int[] rank = {6, 6, 5, 4, 3, 2, 1};

        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        for (int i=0; i<6; i++){
            if(lottos[i] == 0) {
                zeroCnt++;
                continue;
            }
            for (int j=0; j<6; j++){
                if(lottos[i] == win_nums[j]){
                    equalCnt++;
                    break;
                }
            }
        }

        // 1. max
        answer[0] = rank[equalCnt+zeroCnt];
        // 2. min
        answer[1] = rank[equalCnt];

        return answer;
    }

    public static void main(String[] args) {
        PG77484_lotto t = new PG77484_lotto();
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums = {20, 9, 3, 45, 4, 35};

        t.solution(lottos, win_nums);
    }
}
