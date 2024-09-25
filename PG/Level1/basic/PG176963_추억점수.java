package PG.Level1.basic;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * 풀이 날짜 : 2024/09/25
 * 해결 여부 : N
 * https://school.programmers.co.kr/learn/courses/30/lessons/176963?language=java
 */
public class PG176963_추억점수 {


    public static int[] solution02(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        HashMap<String,Integer> map = new LinkedHashMap<>();
        for(int i=0; i< name.length; i++){
            map.put(name[i],yearning[i]);
        }

        for(int i =0; i< photo.length;i++){
            String[] persons = photo[i];
            int score = 0;
            for(int j=0; j<persons.length; j++){
                String person = persons[j];
                // 같은 name이 있다면 점수 저장
                if(map.containsKey(person)){
                    score+=map.get(person);
                }
            }
            answer[i]=score;
        }

        return answer;

    }


    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo  = {
                {"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}
        };

        solution02(name, yearning, photo);
    }
}
