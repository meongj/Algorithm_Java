package PG.Level1.hash;

import java.util.HashMap;
import java.util.HashSet;

// https://school.programmers.co.kr/learn/courses/30/lessons/92334
public class PG92334_신고결과받기 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, HashSet<String>> map = new HashMap<>(); // 신고배열 저장 (key:신고당한유저, value:신고한유저-중복제거)
        HashMap<String, Integer> orderMap = new HashMap<>(); // 유저순서 (key: 유저명, value: 출력순서)

        for (int i = 0; i < id_list.length; i++) { //초기화
            map.put(id_list[i], new HashSet<>());
            orderMap.put(id_list[i], i);
        }
        // 한명씩 신고 체크
        for (int i = 0; i < report.length; i++) {
            String[] tmp = report[i].split(" ");
            String reporter = tmp[0]; // 신고한 사람
            String reported = tmp[1]; // 신고당한 사람
            // 같은 사람이 중복 신고 할수 없다
            map.get(reported).add(reporter);

        }

        // 신고후 정지된 ID
        for(int i=0; i<id_list.length; i++){ //한사람씩 체크
            HashSet<String> reportedList = map.get(id_list[i]); // 신고당한 유저의 신고한 유저들
            // k번 이상 신고되면 메일보낸다
            if (reportedList.size() >= k) { //중복제거된 set(신고한사람)의 개수
                                            // 신고한 유저 K번 이상이면
                // 순서대로 저장해야함
                for (String id : reportedList) {
                    answer[orderMap.get(id)]++; //신고횟수 누적
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PG92334_신고결과받기 t = new PG92334_신고결과받기();
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        t.solution(id_list, report, k);
    }
}
