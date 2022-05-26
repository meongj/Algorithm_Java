package lecture;

import java.util.HashMap;
import java.util.Scanner;

public class Anagram {

    public String solution(String str1, String str2){
        String answer="YES";
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        //str1 map 넣고
        for(char x : str1.toCharArray()){
            map1.put(x, map1.getOrDefault(x, 0)+1);
        }
        //str2 map 넣고
        for(char x : str2.toCharArray()){
            map2.put(x, map2.getOrDefault(x, 0)+1);
        }
        //개수 같은지 비교!
        for(char key : map1.keySet()){
            if(map1.get(key) != map2.get(key))
                answer = "NO";
        }

        return answer;
    }

    public static void main(String[] args) {
        Anagram t = new Anagram();
        Scanner kb = new Scanner(System.in);
        String str1 = kb.next();
        String str2 = kb.next();

        System.out.println(t.solution(str1, str2));
    }
}
