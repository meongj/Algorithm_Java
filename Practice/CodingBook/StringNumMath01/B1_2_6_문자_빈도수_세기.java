package Practice.CodingBook.StringNumMath01;

public class B1_2_6_문자_빈도수_세기 {
    /*
    문자의 빈도수 세기
     */
    public static int countOccurrencesOfACertainCharacter(
        String str, char ch) {
        /*
        1. 문자열에서 해당 문자를 전부 ""로 치환한다(문자를 전부 제거한다)
        2. 원래 문자열의 길이에서 1번에서 얻은 문자열의 길이을 뺀다
        결과 : 해당문자의 개수
         */
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }

    public static int countOccurrencesOfACertainCharacter2(
            String str, String ch) {
        if (ch.codePointCount(0, ch.length()) > 1) {
            // codePointCount : 범위내 유니코드 글자수 출력
            // 주어진 문자열에 유니코드 문자가 둘 이상이면
            return -1;
        }

        int result  = str.length() - str.replace(ch, "").length();

        // ch.length == 를 반환하면, 유니코드 대리 쌍이라는 뜻
        return ch.length() == 2 ? result / 2 : result;
    }

    public static int countOccurrencesOfACertainCharacter3(
            String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }
        return count;
    }

    public static long countOccurrencesOfACertainCharacter4(
            String str, char ch) {
        // 자바 8 함수형 스타일
        return str.chars()
                .filter(c  -> c == ch)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countOccurrencesOfACertainCharacter("aaaaaaabbbbcccccddd", 'a'));
        System.out.println(countOccurrencesOfACertainCharacter2("aaaaaaabbbbcccccddd", "b"));
        System.out.println(countOccurrencesOfACertainCharacter3("aaaaaaabbbbcccccddd", 'a'));
        System.out.println(countOccurrencesOfACertainCharacter4("aaaaaaabbbbcccccddd", 'a'));
    }
}
