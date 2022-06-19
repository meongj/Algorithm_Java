package PG.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PG42746_LargestNumber {

    public String solution(int[] numbers) {
        String answer = "";
        //int -> string
        String[] arr = new String[numbers.length];
        for (int i=0; i<numbers.length; i++){
            arr[i] = String.valueOf(numbers[i]);
        }
        //정렬
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2); // 내림차순 정렬
            }
        });

        if(arr[0].equals("0")) return "0";
        for(String s : arr) {
            answer+= s;
        }

        return answer;
    }

    public static void main(String[] args) {
        PG42746_LargestNumber t = new PG42746_LargestNumber();
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(t.solution(numbers));
    }
}
