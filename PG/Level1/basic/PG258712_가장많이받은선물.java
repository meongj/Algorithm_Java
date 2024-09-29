package PG.Level1.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 풀이 날짜 : 2024/09/29
 * 해결 여부 : N
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */
public class PG258712_가장많이받은선물 {


    /**
     * 처음 푼 내용
     * - 결론, 거의 다 풀었는데 실행이 안됨 ㅠ 다른 답안 참조함
     * - map을 활용한 것은 맞음
     *     - 대신 친구 당 한명씩 준 횟수, 받은 횟수는 `*Map*<String, *Map*<String, Integer>>` `giftMap` 이렇게 저장
     *     - 각 친구의 주고 받은 선물 횟수 (누적 횟수)는 `*Map*<String, Integer> scoreMap = *new* HashMap<>();` 저장해야한다
     * - `giftMap` 을 순회해서 giver, taker 를 찾고 조건 값 비교하는 구간에서 어려움 겪음
     * - 점수 비교하는 map 형식을 너무 어렵게 짬.. 그러다보니 풀 수 없는 경지에 이르름.. 좀 더 쉽게 짤것!
      */

//    public static int solution(String[] friends, String[] gifts) {
//        int answer = 0;
//
//        // 1. 친구당  주고 받은 선물 수 저장
//        Map<String, Map<String, Integer>> friendsMap = new HashMap<>(); // 친구 한명당 주고 받은 횟수 저장
//        Map<String, Map<String, Integer>> giveAndTakeMap = new HashMap<>(); // 친구 간 선물 주고 받은 횟수 저장
//
//        // 친구들당 map 생성 초기화
//        for(String friend : friends) {
//            // 초기화
//            if (!friendsMap.containsKey(friend)) {
//                HashMap<String, Integer> map = new HashMap<>();
//                map.put("give", 0); // 선물 준 횟수
//                map.put("take", 0); // 선물 받은 횟수
//                map.put("giftScore", 0); // 선물지수
//
//                friendsMap.put(friend, map);
//            }
//        }
//
//        System.out.println(friendsMap);
//        // 선물 주고 받은 기록 저장 (친구들끼리간)
//        for (String gift: gifts) {
//            String[] record = gift.split(" ");
//            String giver = record[0];
//            String taker = record[1];
//
//            // 주는 사람 map 생성
//            if (!giveAndTakeMap.containsKey(giver)) {
//                HashMap<String, Integer> map = new HashMap<>();
//
//                map.put(taker, 1); // 선물 받은 횟수 증가
//                giveAndTakeMap.put(giver, map);
//                continue;
//            }
//
//            // 주는 사람 map은 있는데, 받는 사람 map 이 없을 경우 생성 아니면 누적
//            Map<String, Integer> takeMap = giveAndTakeMap.get(giver);
//            if (!takeMap.containsKey(taker)) {
//                // 받는 사람 map 이 없을 경우 생성
//                HashMap<String, Integer> map = new HashMap<>();
//                map.put(taker, 1);
//                giveAndTakeMap.put(giver, map);
//
//                continue;
//            }
//
//            // 있는 경우 누적
//            Integer score = takeMap.get(taker);
//            score += 1;
//            takeMap.put(taker, score);
//        }
//
//
//        // 1-2. 찬구 당 선물지수 저장
//        for (String friend : friendsMap.keySet()) {
//            // 준 횟수가 받은 횟수보다 크면 선물지수 +1
//            Map<String, Integer> giftData = friendsMap.get(friend);
//
//            // "give"와 "take" 값을 비교하고 선물지수 업데이트
//            if (giftData.get("give") > giftData.get("take")) {
//                giftData.put("giftScore", giftData.getOrDefault("giftScore", 0) + 1);
//            }
//        }
//
//
////        System.out.println(friendsMap);
//
//        // 2. 선물 수 비교해서 다음달 받을 선물지수 계산
//        for (String giver : giveAndTakeMap.keySet()) {
//            Map<String, Integer> giftData = giveAndTakeMap.get(giver);
//            String taker = giftData.keySet().toString();
//
//
//        }
//
//
//        // 3. 주고 받은 적 없거나 같은 수 일경우 선물지수 계산
//
//        // 4. 선물 지수 제일 큰 친구의 index 출력
//
//        return answer;
//    }

    // 다른 답안 참조
    public static int solution02(String[] friends, String[] gifts) {
        Map<String, Map<String, Integer>> giftMap = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>(); // 친구의 선물지수 누적

        for (String gift : gifts) {
            String[] tmp = gift.split(" ");
            String giver = tmp[0];
            String taker = tmp[1];
            // 주는 사람이면 더하고 받는 사람이면 뺀다
            scoreMap.put(giver, scoreMap.getOrDefault(giver, 0) + 1);
            scoreMap.put(taker, scoreMap.getOrDefault(taker, 0) - 1);

            Map<String, Integer> map = giftMap.getOrDefault(giver, new HashMap<>());
            map.put(taker, map.getOrDefault(taker, 0) + 1);
            giftMap.put(giver, map);
        }

        Map<String, Integer> takeCntMap = new HashMap<>();
        int answer = 0;

        int friendsLen = friends.length;
        // 모든 친구들 리스트 순회해서 서로 주고 받은 리스트에 있는 지 체크
        for (int i = 0; i < friendsLen - 1; i++) {
            String giver = friends[i];
            // 순회한 친구의 준 횟수, 받은 횟수 조회
            Map<String, Integer> giverMap = giftMap.getOrDefault(giver, new HashMap<>());

            for (int j = i + 1; j < friendsLen; j++) {
                String taker = friends[j];
                Map<String, Integer> takerMap = giftMap.getOrDefault(taker, new HashMap<>());

                int giveCnt = giverMap.getOrDefault(taker, 0) - takerMap.getOrDefault(giver, 0);

                if (giveCnt == 0) {
                    giveCnt = scoreMap.getOrDefault(giver, 0) - scoreMap.getOrDefault(taker, 0);
                }

                int takeCnt = 0;
                if (giveCnt > 0) {
                    takeCnt = takeCntMap.getOrDefault(giver, 0) + 1;
                    takeCntMap.put(giver, takeCnt);
                }

                if (giveCnt < 0) {
                    takeCnt = takeCntMap.getOrDefault(taker, 0) + 1;
                    takeCntMap.put(taker, takeCnt);
                }

                answer = Math.max(answer, takeCnt);
                takerMap.remove(giver);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};

        solution02(friends, gifts);
    }
}
