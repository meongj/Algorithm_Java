package Practice.Book.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class B04_두배열의원소교체 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = kb.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr2[i] = kb.nextInt();
        }
        // 오름차순
        Arrays.sort(arr1);
        // 내림차순
        Integer[] arr3 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        Arrays.sort(arr3, Collections.reverseOrder());

        int cnt = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // arr1 원소가 arr3원소보다 작은 경우
            // 두원소 교체하기
            if(arr1[i] < arr3[i]) {
                int tmp = arr1[i];
                arr1[i] = arr3[i];
                arr3[i] = tmp;
                cnt++;
            }
            if(cnt == k) break;
        }

        for (int i = 0; i < n; i++) {
            sum += arr1[i];
        }
        System.out.println(sum);
    }
}
