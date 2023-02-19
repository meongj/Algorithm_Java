package Practice.CodingBook.StringNumMath01;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class B1_2_14_빈도수가_가장높은문자찾기 {

    // HashMap 사용해서 빈도수 value 저장
    public static char maxOccurenceCharacter(String str) {
        Map<Character, Integer> counter = new HashMap<>(); // 문자열 빈도수 저장
        char[] chStr = str.toCharArray();

        for(int i =0 ; i < chStr.length; i++) {
            char currentCh = chStr[i];
            if (!Character.isWhitespace(currentCh)) { // 여백제거
                Integer noCh = counter.get(currentCh);
                if (noCh == null) {
                    counter.put(currentCh, 1);
                } else {
                    counter.put(currentCh, ++noCh);
                }
            }
        }

        // 빈도수 가장 높은 문자
        int maxOccurrences = Collections.max(counter.values());
        char maxCharacter = Character.MIN_VALUE;

        for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
            if (entry.getValue() == maxOccurrences) {
                maxCharacter = entry.getKey();
            }
        }
        return maxCharacter;
    }

    public static void main(String[] args) {
        B1_2_14_빈도수가_가장높은문자찾기 t = new B1_2_14_빈도수가_가장높은문자찾기();
        String str = "aaaaaaaaaaa  aaaaaaaa bbbcccx xxxxxxxxx";
        System.out.println(t.maxOccurenceCharacter(str));
    }
}
