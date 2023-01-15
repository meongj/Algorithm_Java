package Practice.CodingBook.StringNumMath01;

public class B1_2_4_숫자만포함하는문자열인지검사 {
    public static boolean containOnlyDigits(String str) {
        for (int i=0; i < str.length(); i++) {
            // 숫자가 아니라면
            if (!Character.isDigit(str.charAt(i))) { // 숫자 판변1
                return false;
            }
        }
        return true;
    }

    public static boolean containsDigits02(String str) {
        return !str.chars()
                .anyMatch(n -> !Character.isDigit(n)); // 숫자 판별2
    }

    public static boolean containsDigits03(String str) {
        return str.matches("[0-9]+"); // 숫자판별3
    }

    public static void main(String[] args) {
        String str = "111122233335555";
        String str2 = "string 입니다.";
        System.out.println(containOnlyDigits(str));
        System.out.println(containOnlyDigits(str2));
        System.out.println(containsDigits02(str));
        System.out.println(containsDigits02(str2));
        System.out.println(containsDigits03(str));
        System.out.println(containsDigits03(str2));
    }
}
