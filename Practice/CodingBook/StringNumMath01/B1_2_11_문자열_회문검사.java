package Practice.CodingBook.StringNumMath01;

import java.util.stream.IntStream;

public class B1_2_11_문자열_회문검사 {
    /**
     * 회문(Palindrome) 이란?
     * 거꾸로 뒤집어도 똑같은 문자열 또는 수
     * ex) madam -> madam
     *
     * 구현?
     * 중간에서 만나는 방식으로 문자열 혹은 수 비교
     * */

    // 1. while 문 사용
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (right > left) { // 중간지점 만나기 전까지 비교
            if (str.charAt(left) != str.charAt(right)) { // 팰린드롬이 아닌경우
                return false;
            }
            left++;
            right--;
        }
        return true; // 팰린드롬
    }

    // 2. for문 사용
    public static boolean isPalindrome2(String str) {
        int n = str.length();
        for (int i = 0; i < n/2; i++) { // 중간지점 전까지 비교
            if (str.charAt(i) != str.charAt(n-i-1)) {
                return false;
            }
        }
        return true;
    }

    // 3. reverse() 사용
    public static boolean isPalindrome3(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // 4. 자바8 함수 사용
    public static boolean isPalindrome4(String str) {
        return IntStream.range(0, str.length() / 2)
                .noneMatch(p -> str.charAt(p) != str.charAt(str.length() - p - 1));
    }

        public static void main(String[] args) {
        B1_2_11_문자열_회문검사 t = new B1_2_11_문자열_회문검사();
        String str1 = "madam";
        String str2 = "madame";

        System.out.println(t.isPalindrome(str1));
        System.out.println(t.isPalindrome(str2));

        System.out.println(t.isPalindrome2(str1));
        System.out.println(t.isPalindrome2(str2));

        System.out.println(t.isPalindrome3(str1));
        System.out.println(t.isPalindrome3(str2));

        System.out.println(t.isPalindrome4(str1));
        System.out.println(t.isPalindrome4(str2));

    }
}
