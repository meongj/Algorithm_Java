package Practice.CodingBook.StringNumMath01;

public class B1_2_22_가장긴_공통접두사_찾기 {
    public static String longestCommonPrefix (String[] strs) {
        if (strs.length == 1)
            return strs[0];

        int firstLen = strs[0].length(); // 비교대상 지정(첫번째 배열)

        for (int prefixLen = 0; prefixLen < firstLen; prefixLen++) {
            char ch = strs[0].charAt(prefixLen);
            // 배열들끼리 비교
            for (int i = 1; i < strs.length; i++) {
                // 안되는 조건들 처리
                if (prefixLen >= strs[i].length()
                || strs[i].charAt(prefixLen) != ch) {
                    return strs[i].substring(0, prefixLen);
                }
            }
        }
        return strs[0];
    }
    public static void main(String[] args) {
        B1_2_22_가장긴_공통접두사_찾기 t = new B1_2_22_가장긴_공통접두사_찾기();
        String[] text  = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};
        System.out.println(t.longestCommonPrefix(text));
    }
}
