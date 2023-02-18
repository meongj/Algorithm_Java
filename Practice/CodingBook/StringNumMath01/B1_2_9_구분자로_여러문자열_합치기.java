package Practice.CodingBook.StringNumMath01;

import java.util.Arrays;
import java.util.stream.Collectors;

public class B1_2_9_구분자로_여러문자열_합치기 {

    public static String joinByDelimiter(char delimiter, String ... args) {
        StringBuilder result = new StringBuilder();

        int i = 0;
        for (i = 0; i < args.length -1 ; i++) {
            result.append(args[i]).append(delimiter);
        }
        result.append(args[i]);

        return result.toString();
    }

    public static String joinByDelimiter02(char delimiter, String ... args) {
        return Arrays.stream(args, 0, args.length)
                .collect(Collectors.joining(String.valueOf(delimiter)));
    }

        public static void main(String[] args) {
        B1_2_9_구분자로_여러문자열_합치기 t = new B1_2_9_구분자로_여러문자열_합치기();
        String[] arr = {"문자열1", "문자열2입니다", "문자열3333"};
        System.out.println(t.joinByDelimiter('&', arr));

        // 자바 8 : 문자열 합치기
        String result = String.join(" ", "how", "are", "you" );
        System.out.println("result: " + result);

            System.out.println(t.joinByDelimiter02('$', arr));
    }
}
