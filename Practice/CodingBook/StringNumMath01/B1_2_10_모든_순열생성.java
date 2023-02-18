package Practice.CodingBook.StringNumMath01;

public class B1_2_10_모든_순열생성 {

    public static void permuteAndPrint(String str) {
        permuteAndPrint("", str);
    }

    public static void permuteAndPrint(String prefix, String str) {
        int n = str.length();

        if (n == 0) {
            System.out.print(prefix + " ");
        } else {
            for (int i = 0; i < n; i++) {
                permuteAndPrint(prefix + str.charAt(i),
                        str.substring(i + 1, n) + str.substring(0, i));
            }
        }
    }

    public static void main(String[] args) {
        B1_2_10_모든_순열생성 t = new B1_2_10_모든_순열생성();
        t.permuteAndPrint("ABC");
    }
}
