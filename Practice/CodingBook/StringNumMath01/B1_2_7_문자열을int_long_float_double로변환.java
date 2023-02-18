package Practice.CodingBook.StringNumMath01;

public class B1_2_7_문자열을int_long_float_double로변환 {
    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";

    // exception 처리용
    private static final String WRONG_NUMBER = "453w";

    public static void main(String[] args) {
        // String to int
        int toInt = Integer.parseInt(TO_INT);
        // String to Long
        long toLong = Long.parseLong(TO_LONG);
        // String to float
        float toFloat = Float.parseFloat(TO_FLOAT);
        // String to double
        double toDouble = Double.parseDouble(TO_DOUBLE);

        // String to Integer 객체
        Integer toInt02 = Integer.valueOf(TO_INT);
        // String to Long 객체
        Long toLong02 = Long.valueOf(TO_LONG);
        // String to Float 객체
        Float toFloat2 = Float.valueOf(TO_FLOAT);
        // String to Double 객체
        Double toDouble2 = Double.valueOf(TO_DOUBLE);


        // String 을 성공적으로 변환시키지 못할 경우
        // 자바는 NumberFormatException을 던진다
        try {
            Integer toInt03 = Integer.valueOf(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println(e);
        }

        try {
            int toInt03 = Integer.parseInt(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println(e);
        }


    }
}
