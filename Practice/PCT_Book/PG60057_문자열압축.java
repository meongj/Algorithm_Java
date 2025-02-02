package Practice.PCT_Book;

import java.util.ArrayList;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class PG60057_문자열압축 {

    public static int solution(String s) {
        int min = Integer.MAX_VALUE;

        // 1. 1부터 문자열 길이 만큼 문자열 길이 설정하며 반복

        for (int length = 1; length <= s.length(); length++) {
            // 문자열 압축 후 가장 짧은 길이 선택
            int compressed = compress(s, length);
            if (compressed < min) {
                min = compressed;
            }
        }


        return min;
    }

    // 자르는 길이만큼 문자열 잘라 리스트 반환
    // 직전 문자열과 비교하기 위해 리스트 사용
    private static List<String> split(String source, int length) {
        List<String> tokens = new ArrayList<>();
        // source를 length 만큼 잘라 tokens 리스트에 추가
        for( int startIndex = 0; startIndex < source.length(); startIndex += length) {
            int endIndex = startIndex + length;
            // 문자열 길이를 벗어날 수는 없다
            if (endIndex > source.length()) endIndex = source.length();

            // 문자열 을 startIndex 부터 endIndex 까지 잘라 tokens 리스트에 추가
            tokens.add(source.substring(startIndex, endIndex));
        }
        return tokens;
    }


    // 압축
    private static int compress(String source, int length) {
        StringBuilder builder = new StringBuilder();

        String last = ""; // 직전 문자열
        int count = 0;

        for(String token : split(source, length) ) {
            // 직전에 등장한 문자열과 같다면 횟수 증가
            if (token.equals(last)) {
                count++;
            } else { // 새로운 토큰 증가 처리
                // count 2 이상일 경우만 압축 문자열에 포함 (1은 생략)
                if (count > 1) builder.append(count);

                builder.append(last);
                // 초기화
                last = token;
                count = 1;
            }
        }
        // 마지막 토큰 추가
        if (count > 1) builder.append(count);
        builder.append(last);

        return builder.length();

    }



    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }
}
