package PG.Level2.hash;

import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/42577
public class PG42577_전화번호목록 {
    // 효율성 케이스 실패 (시간초과 발생)
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = i+1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return answer;
    }

    public boolean solution2(String[] phone_book) {
        //hashmap 사용 (key=phone 만 저장)
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< phone_book.length; i++)
            map.put(phone_book[i], i);

        for (String target : phone_book){
            for (int i=0; i< target.length(); i++){
                // target의 0의 자리부터 비교해서 key에 해당 값이 있는지 찾는다
                // 0부터 앞의 자리만 비교하기 때문에 자기 자신이 같아서 걸려질 일이 없다
                if(map.containsKey(target.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }




    public static void main(String[] args) {
        PG42577_전화번호목록 t = new PG42577_전화번호목록();
        String[] phone_book = {"119", "97674223", "1195524421"};
        String[] phone_book2 = {"123","456","789"};
        String[] phone_book3 = {"12","123","1235","567","88"};

        System.out.println(t.solution2(phone_book));
        System.out.println(t.solution2(phone_book2));
        System.out.println(t.solution2(phone_book3));

    }
}
