package BOJ.BruteForce;

import java.util.ArrayList;
import java.util.Scanner;

class body{
    int x;
    int y;
    body(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Boj7568_Bulk {

    public static void main(String[] args) {
        Boj7568_Bulk t = new Boj7568_Bulk();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<body> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            int a = kb.nextInt();
            int b = kb.nextInt();
            arr.add(new body(a, b));
        }

        int cnt=1;
        String answer ="";

        for(int i=0; i<n; i++){
            cnt=1;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(arr.get(i).x < arr.get(j).x){
                    if(arr.get(i).y < arr.get(j).y){
                        cnt++;
                    }
                }
            }
            answer+= cnt + " ";
        }

        System.out.println(answer);

    }
}
