package BOJ.BruteForce;

import java.util.Scanner;

public class Boj1476_날짜계산 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int e = kb.nextInt();
        int s = kb.nextInt();
        int m = kb.nextInt();
        int day_e = 1, day_s = 1, day_m = 1;
        int year = 1;

        while (true) {
            if(e == day_e && m == day_m && s == day_s) break;
            year++;
            day_e++;
            day_m++;
            day_s++;
            if(day_e == 16) day_e = 1;
            if(day_s == 29) day_s = 1;
            if(day_m == 20) day_m = 1;
        }
        System.out.println(year);
    }
}
