package Practice.Book.Array;

import java.util.*;

public class B03_성적이낮은순서로학생출력 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String key = kb.next();
            int value = kb.nextInt();
            map.put(key, value);
        }
        // map 성적이 낮은 순으로 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(Map.Entry<String, Integer> entry : entryList){
           answer += entry.getKey() + " ";
        }
        System.out.println(answer);
    }
}
