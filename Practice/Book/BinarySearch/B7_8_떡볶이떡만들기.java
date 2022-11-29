package Practice.Book.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class B7_8_떡볶이떡만들기 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n]; // 떡길이

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        Arrays.sort(arr);
        // 이진 탐색을 위한 시작점과 끝점 설정
        int start = 0;
        int end = arr[n-1]; // 최대길이

        // 이진 탐색수행(반복적)
        int result = 0; // 절단기 길이 최대값
        while(start <= end) {
            int total = 0; // 자른 떡길이 합
            int mid = (start+end)/2;

            for(int i=0; i<n; i++) {
                if (arr[i] > mid)
                    total += arr[i] - mid; // 자른 부분의 합 누적
            }
            // 떡의 양이 부족한 경우 더 많이 자르기(왼쪽 부분 탐색)
            if(total < m)
                end = mid - 1;
            // 떡 양이 충분한 경우 덜자르기(오른쪽 부분 탐색)
            else {
                result = mid; // 최대한 덜 잘랐을때가 정답
                start = mid + 1;
            }
        }

        System.out.println(result);

    }
}
