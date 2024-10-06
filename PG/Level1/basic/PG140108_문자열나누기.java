package PG.Level1.basic;


/**
 * 풀이 날짜 : 2024/10/06
 * 해결 여부 : N
 * https://school.programmers.co.kr/learn/courses/30/lessons/140108?language=java
 */
public class PG140108_문자열나누기 {

    /**
     * 처음엔 Map 타입을 생각했으나 포함여부 등과 같은 조건식이 많아져서 방법을 우회
     * 횟수를 증가하거나 차감해서 특정 횟수에 도달하면 결과값을 추가 형태로 변경
     * 하지만, 리스트 형태의 값을 비교하는 데 있어 방법을 잘 못세움 --> 해결책: 기준값을 미리 저장한후 다음 값을 비교하는 방법을 차용
     */
    // 처음 생각
    public static int solution(String s) {
        int answer = 0;
        Character x = null;
        // char 타입 배열로 변경
        char[] chars = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < chars.length; i++) {
            //  x 와 x 가 아닌 문자로 나눔
            if (x == null) x = chars[i];

            if (i+1 == chars.length) {
                break;
            } else if (i+1 > chars.length){
                answer++;
                break;
            }
            char y = chars[i+1];

            cnt = (x != y) ? cnt+1: cnt-1;

            if (cnt == 1) {
                answer++;
                i = i+1;
                x = null;
                cnt =0 ;
            }

        }
        return answer;
    }

    // 참고한 생각
    public static int solution02(String s) {
        int answer = 0;
        char init = s.charAt(0);
        int count = 0;
        // 같으면 count증가, 다르면 감소 시켜서 0 이 되면 횟수를 추가한다
        for (char c : s.toCharArray()) {
            if (count == 0) {
                init = c;
            }
            if (init == c) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                answer++;
            }
        }

        if(count > 0) {
            answer++;
        }
        return answer;
    }


    public static void main(String[] args) {
        String str1 = "banana";
        String str2 = "abracadabra";
        String str3 = "aaabbaccccabba";
        solution02(str3);
    }
}
