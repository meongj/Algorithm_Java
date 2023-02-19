package Practice.CodingBook.StringNumMath01;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class B1_2_13_주어진문자제거 {

    // 1. 정규식 사용
    public static String removeCharacter(String str, char ch) {
        // Pattern.quote() : <, (, [, {, -, = 등과 같은 특수문자를 이스케이프하기 위해
        return str.replaceAll(Pattern.quote(String.valueOf(ch)),  "");
    }

    // 2. StringBuilder 사용
    public static String removeCharacter2(String str, char ch) {
        StringBuilder sb = new StringBuilder();
        char[] chArray = str.toCharArray();

        for (char c : chArray) {
            if (c != ch) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 3. 자바8 함수형
    public static String removeCharacter3(String str, char ch) {
        return str.chars() // 문자열을 intStream 으로 변환
                .filter(c -> c != ch) // 필터링해 중복제거
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining()); // 스프림의 문자열을 조인해 하나의 문자열로 모음
    }

    public static void main(String[] args) {
        B1_2_13_주어진문자제거 t = new B1_2_13_주어진문자제거();
        String str = "aaaaa!!!aabbbbbbb@bbbccccccccc&ccccccc!!&&&&&";
        System.out.println(t.removeCharacter(str, '!'));
        System.out.println(t.removeCharacter2(str, '@'));
        System.out.println(t.removeCharacter3(str, '&'));
    }
}
