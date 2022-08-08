package BOJ.Hash;

import java.util.*;

// https://www.acmicpc.net/problem/1764
public class Boj1764_듣보잡 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        HashSet<String> map = new HashSet<String>(); // 이룸, 개수
        List<String> list = new ArrayList<>();
        // 없으면 map 초기화
        // 있으면 넣기
        for (int i=0; i<n; i++) {
            String name = kb.next();
            map.add(name);
        }
        for (int i=0; i<m; i++) {
            String name = kb.next();
            if (map.contains(name)){
                list.add(name);
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (String name : list){
            System.out.println(name);
        }

    }
}
