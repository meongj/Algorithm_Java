package PG.Level1.basic;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 풀이 날짜 : 2024/10/02
 * 해결 여부 : N
 * https://school.programmers.co.kr/learn/courses/30/lessons/250121
 */
public class PG250121_데이터분석 {

    // 기준점이 되는 index 저장, 정렬할 index 저장
    static int idx, sortIdx;
    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer = {};

        if(ext.equals("code")) idx = 0;
        if(ext.equals("date")) idx = 1;
        if(ext.equals("maximum")) idx = 2;
        if(ext.equals("remain")) idx = 3;

        if(sort_by.equals("code")) sortIdx = 0;
        if(sort_by.equals("date")) sortIdx = 1;
        if(sort_by.equals("maximum")) sortIdx = 2;
        if(sort_by.equals("remain")) sortIdx = 3;

        // 기준점이되는 값보다  작은 값만 저장
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] arr : data) {
            if (arr[idx] < val_ext) {
                list.add(arr);
            }
        }


        // sort_by 기준으로 정렬
        Collections.sort(list, (o1, o2) -> {
            return o1[sortIdx] - o2[sortIdx];
        });

        answer = new int[list.size()][];
        for(int i =0 ; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return  answer;
    }


    public static void main(String[] args) {
        int[][] data = {
                {1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}
        };
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";

        solution(data, ext, val_ext, sort_by);
    }
}
