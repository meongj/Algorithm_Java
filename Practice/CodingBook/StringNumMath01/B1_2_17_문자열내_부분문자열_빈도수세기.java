package Practice.CodingBook.StringNumMath01;

import java.util.regex.Pattern;

public class B1_2_17_문자열내_부분문자열_빈도수세기 {

    // 1. indexOf() 사용
    // 명시한 문자열이 처음 인덱스를 반환한다
    // 나오지 않으면 -1 반환
    public static int countStringInString(String string, String toFind) {
        int position = 0;
        int count = 0;
        int n = toFind.length();

        while ((position = string.indexOf(toFind, position)) != -1) { // 문자열이 나오지 않을 때까지 돈다
            position = position + n;
            count++;
        }
        return count;
    }

    // 2. split 사용
    public static int countStringInString02(String string, String toFind) {
        int result = string.split(Pattern.quote(toFind), -1).length - 1;
        return result < 0 ? 0 : result;
    }


    public static void main(String[] args) {
        B1_2_17_문자열내_부분문자열_빈도수세기 t = new B1_2_17_문자열내_부분문자열_빈도수세기();
        String str = "사abcaaaabcbbbbabcccccccccc";
        System.out.println(t.countStringInString(str, "abc"));
        System.out.println(t.countStringInString02(str, "abc"));
    }
}
