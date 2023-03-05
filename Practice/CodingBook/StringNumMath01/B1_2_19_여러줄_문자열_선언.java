package Practice.CodingBook.StringNumMath01;

public class B1_2_19_여러줄_문자열_선언 {
    private static final String LS = System.lineSeparator(); // 줄 구분자

    public static void main(String[] args) {
        // jdk 8 이후 사용
        String text = String.join(LS,
                "My high school, ",
                "the illonois mathmatics ans Science Academy, ",
                "showed me that anything is possible");
        System.out.println(text);
        // jdk 8 이전 사용
        StringBuilder sb = new StringBuilder();
        sb.append("My high school,").append(LS);
        sb.append("the illonois mathmatics ans Science Academy, ").append(LS);
        sb.append("showed me that anything is possible").append(LS);
        System.out.println(sb.toString());

        // String.Format 시 (문자열 형식 지정)
        String text2  = String.format("%s" + LS + "%s" + LS + "%s" + LS,
                "My high school,",
                "the illonois mathmatics ans Science Academy, ",
                "showed me that anything is possible");
        System.out.println(text2);
    }
}
