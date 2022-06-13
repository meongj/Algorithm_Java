package PG.Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class PG42888_OpenChat {

    public String[] solution(String[] record) {
        String[] answer = {};
        ArrayList<String> arr = new ArrayList<>();
        //key= uid / value=nickname
        Map<String, String> map = new HashMap<>();// 닉네임 중복허용

        for (String s : record){
            String[] word = s.split(" ");
            String flag = word[0];
            String uid = word[1];
            if(flag.equals("Enter")){ //들어온경우
                String nickname = word[2];
                //이전에 들어왔는지 확인, 있다면 변경
                map.put(uid, nickname);
                arr.add(uid + "님이 들어왔습니다.");

            }else if(flag.equals("Leave")){
                arr.add(uid + "님이 나갔습니다.");
            }else if(flag.equals("Change")){
                String nickname = word[2];
                map.replace(uid, nickname);
            }
        }
        answer = new String[arr.size()];
        for (int j=0; j<arr.size(); j++) {
            int uid_loc = arr.get(j).indexOf("님");
            String uid= arr.get(j).substring(0,uid_loc);
            answer[j]= arr.get(j).replace(uid, map.get(uid));
        }
        return answer;
    }

    public static void main(String[] args) {
        PG42888_OpenChat t =new PG42888_OpenChat();
        String[] record= {
                "Enter uid1234 Muzi",
                "Enter uid4567 Prodo",
                "Leave uid1234",
                "Enter uid1234 Prodo",
                "Change uid4567 Ryan"};

        System.out.println(t.solution(record));
    }
}
