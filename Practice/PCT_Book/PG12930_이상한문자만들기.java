package Practice.PCT_Book;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 * 풀이 날짜 : 2025/01/23
 */
public class PG12930_이상한문자만들기 {

    public static String solution(String s) {
        //String -> char[]
        StringBuilder result = new StringBuilder();
         // 짝 -> 대, 홀 -> 소
        for(char c :  s.toCharArray()) {
            // 공백체크
            if (!Character.isAlphabetic(c)) {
                // 공백처리
                result.append(c);
            } else {
                // 알파벳 변환
                if (c%2 == 0) {
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append(Character.toLowerCase(c));
                }
            }
        }

        // char[] -> String
        return result.toString();
    }
    
    public static void main(String[] args) {
        String s = "try hello world";
        String returnVal = solution(s);
        solution(returnVal);

    }
}
