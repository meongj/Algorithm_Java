package Practice.Book;

import java.util.Scanner;

public class B42_시각 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int cnt = 0;
        for(int i = 0; i <= n; i++) { // 시(n)
            for (int j = 0; j < 60; j++) { // 분(59)
                for (int k = 0; k < 60; k++) { // 초(59)
                    String str = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
                    if (str.contains(String.valueOf(n))) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
