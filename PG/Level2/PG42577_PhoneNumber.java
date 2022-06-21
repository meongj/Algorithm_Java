package PG.Level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PG42577_PhoneNumber {

    public boolean solution(String[] phone_book) {
        //hashmap 사용 (key=phone 만 저장) - 중복저장x
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i< phone_book.length; i++)
            map.put(phone_book[i], i);

        for (String target : phone_book){
            for (int i=0; i< target.length(); i++){
                if(map.containsKey(target.substring(0,i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PG42577_PhoneNumber t = new PG42577_PhoneNumber();
        String[] s = {"123","456","789"};
        System.out.println(t.solution(s));
    }
}
