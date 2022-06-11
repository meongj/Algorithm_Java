package PG.Level1;

public class PG86051_NoNumber {

    public int solution(int[] numbers) {
        int answer = 0;
        int[] ch = new int[10];//0~9 체크 배열
        for (int num : numbers){
            ch[num] = 1;
        }
        for (int i=0; i<ch.length; i++){
            if(ch[i]!=1) answer+=i;
        }

        return answer;
    }
    public static void main(String[] args) {
        PG86051_NoNumber t = new PG86051_NoNumber();
        int[] arr = {1,2,3,4,6,7,8,0};
        System.out.println(t.solution(arr));
        int[] arr2 = {5,8,4,0,6,7,9};
        System.out.println(t.solution(arr2));

    }
}
