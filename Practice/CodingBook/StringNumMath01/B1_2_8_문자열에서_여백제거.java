package Practice.CodingBook.StringNumMath01;

public class B1_2_8_문자열에서_여백제거 {

    // \\s 는 \t, \n, \r 처럼 보이지 않는 여백을 포함해 모든 여백 제거함
    public static String removeWhiteSpace(String str) {
        return str.replaceAll("\\s", "");
    }

    public static void main(String[] args) {
        B1_2_8_문자열에서_여백제거 t = new B1_2_8_문자열에서_여백제거();
        String str = "string test testtt \t"
                    + "space test test\n"
                    + "3번째 줄입니다.\r";
        System.out.println(t.removeWhiteSpace(str));
    }
}
