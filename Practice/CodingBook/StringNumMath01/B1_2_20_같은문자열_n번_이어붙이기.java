package Practice.CodingBook.StringNumMath01;

import java.util.Collections;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class B1_2_20_같은문자열_n번_이어붙이기 {

    public static String concatRepeat(String str, int n) {
        StringBuilder sb = new StringBuilder(str.length() * n);

        for (int i = 0; i < n ; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        B1_2_20_같은문자열_n번_이어붙이기 t = new B1_2_20_같은문자열_n번_이어붙이기();
        String str  = "hello";
        // 1. StrinbBuilder 사용
        System.out.println(t.concatRepeat(str, 5));
        // 2. String.repeat 사용
        String result = "hello".repeat(5);
        System.out.println(result);
        // 3. 그 외
        String result2 = String.join("", Collections.nCopies(5, "hello"));
        System.out.println(result2);

        String result3 = Stream.generate(() -> "hello")
                .limit(5)
                .collect(joining());
        System.out.println(result3);

    }
}
