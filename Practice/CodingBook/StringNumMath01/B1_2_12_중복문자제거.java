package Practice.CodingBook.StringNumMath01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class B1_2_12_중복문자제거 {

    // 1. StringBuilder 사용
    public static String removeDuplicates(String str) {
        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (char ch : chArray) {
            if (sb.indexOf(String.valueOf(ch)) == -1) { // -1이면 stringbuilder에 해당 문자가 없다면
                sb.append(ch); // 문자 추가해라
            } // 있는 경우엔 추가 안되어 자동으로 중복문자가 제거되어 저장되게 된다
        }
        return sb.toString();
    }

    // 2. hashSet 사용
    public static String removeDuplicates2(String str) {
        char[] chArray = str.toCharArray();
        StringBuilder sb = new StringBuilder(); // 값 저장소
        Set<Character> chHashSet = new HashSet<>(); // Set은 중복제거

        for (char c : chArray) {
            // HashSet에서
            // add(value) == true -> 값이 내부에 존재하지않는다면 true 반환
            // add(value) == false -> 값이 내부에 존재한다면 false 반환
            if (chHashSet.add(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // 3. 자바8 distinct() 함수 사용
    public static String removeDuplicates3(String str) {
        return Arrays.asList(str.split("")).stream()
                .distinct()
                .collect(Collectors.joining());
    }
    public static void main(String[] args) {
        B1_2_12_중복문자제거 t = new B1_2_12_중복문자제거();
        String str = "aaaabbbbcccccccccccc";

        System.out.println(t.removeDuplicates(str));
        System.out.println(t.removeDuplicates2(str));
        System.out.println(t.removeDuplicates3(str));
    }
}
