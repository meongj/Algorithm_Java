package lecture;

import java.util.Scanner;

class FindLongSentense {

    /*
    문장 속 가장 긴 단어 출력하기
     */
    public String solution(String str){
        String answer = "";
        int max = Integer.MIN_VALUE;//가장 작은 값으로 초기화

        String[] s = str.split(" ");

        for(String x : s){
            int len = x.length();
            if(len > max){
                max = len;
                answer = x;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        FindLongSentense T = new FindLongSentense();
        Scanner kb = new Scanner(System.in);
        String str = kb.nextLine();

        System.out.println(T.solution(str));

    }

}
