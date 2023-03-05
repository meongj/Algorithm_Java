package Practice.CodingBook.StringNumMath01;

import java.util.Arrays;

public class B1_2_18_두문자열이_애너그램인지_검사 {
    private static final int EXTENDED_ASCII_CODES = 256;
    // 1. 문자열 비교
    public static boolean isAnagram(String str1, String str2) {
        // 1-1. 소문자로 변환
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        // 1-2. 여백제거
        str1 = str1.replace(" ", "");
        str2 = str2.replace(" ", "");

        // 1-3. 정렬
        char[] c1 = str1.toCharArray();
        char[] c2 = str2.toCharArray();

        Arrays.sort(c1);
        Arrays.sort(c2);

        str1 = String.valueOf(c1);
        str2 = String.valueOf(c2);
        // 1-4. 비교
        if (str1.equals(str2)) return true;
        return false;
    }

    // 2. 아스키 코드 비교
    public static boolean isAnagram2(String str1, String str2) {
        int[] chCounts = new int[EXTENDED_ASCII_CODES];
        // \\s : 단일 공백 정규식 표현
        char[] chStr1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] chStr2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        // 길이 비교
        if (chStr1.length != chStr2.length)
            return false;

        // 아스키 배열 저장
        for (int i = 0; i < chStr1.length; i++) {
            chCounts[chStr1[i]]++;
            chCounts[chStr2[i]]--;
        }
        // 아스키 배열값이 0이 아니면 같은 값 이외의 값이 있다는 말로 같은 애너그램이 아니다.
        for (int i = 0; i < chCounts.length; i++) {
            if (chCounts[i] != 0)
                return false;
        }
        return true;
    }



        public static void main(String[] args) {
        B1_2_18_두문자열이_애너그램인지_검사 t = new B1_2_18_두문자열이_애너그램인지_검사();
        String str1 = "H e llo";
        String str2 = "oehLL ";
        String str3 = "h lll e";
        System.out.println(t.isAnagram(str1, str2));
        System.out.println(t.isAnagram(str1, str3));
        System.out.println(t.isAnagram2(str1, str2));
        System.out.println(t.isAnagram2(str1, str3));
    }
}
