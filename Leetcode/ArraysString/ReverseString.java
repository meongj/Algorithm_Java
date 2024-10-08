package Leetcode.ArraysString;

/**
 * 문자 거꾸로 변환
 * point : swap 사용
 * - 맨앞과 맨뒤는 같이 자리를 swap 한다
 */
public class ReverseString {

    public static char[] reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
        return s;
    }
    public static void main(String[] args) {
        char[] input = {'h','e','l','l','o'};
        reverseString(input);
    }
}
