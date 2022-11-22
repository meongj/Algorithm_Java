package Practice.Book.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class B02_부품찾기 {
    // 이진탐색 코드 구현
    public static String binary_search(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end)/2;
            // 찾은경우 중간점 인덱스 반환
            if(arr[mid] == target)
                return String.valueOf(mid);
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target)
                end = mid - 1;
            // 중간점의 값보가 찾고자 하는 값이 큰 경우 오른쪽 확인
            else
                start = mid + 1;
        }
        return "None"; // 찾지못한 경우
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        // 가게의 부품 개수
        int n = kb.nextInt();
        // 가게의 부품종류
        int[] arr_n = new int[n];
        for (int i=0; i<n; i++) {
            arr_n[i] = kb.nextInt();
        }
        Arrays.sort(arr_n); // 이진탐색 수행하기 위해 사전에 정렬 수행
        // 손님이 확인 요청한 부품개수
        int m = kb.nextInt();
        // 손님이 확인 요청한 전체 부품번호
        int[] arr_m = new int[m];
        for (int i=0; i<m; i++) {
            arr_m[i] = kb.nextInt();
        }

        // 손님이 확인 요청한 부품 번호를 하나씩 확인
        for (int i=0; i<m; i++) {
            // 해당 부품이 존재하는지 확인
            String result = binary_search(arr_n, arr_m[i], 0, n-1);
            if (!"None".equals(result))
                System.out.print("yes" + " ");
            else
                System.out.print("no" + " ");
        }

    }
}
