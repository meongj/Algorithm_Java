package Practice.Book.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B02_위에서아래로 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int[] arr = new int[n];
        String answer = "";
        for (int i=0; i<n; i++)
            arr[i]=kb.nextInt();

        // 내림차순 정렬
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Collections.reverseOrder());

        for (int i=0; i<arr2.length; i++)
            answer += arr2[i] + " ";

        System.out.println(answer);
    }
}
