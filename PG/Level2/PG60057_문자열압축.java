package PG.Level2;
// https://school.programmers.co.kr/learn/courses/30/lessons/60057
public class PG60057_문자열압축 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= s.length()/2; i++) { //n개씩 자른다
            int cnt = 1; // 문자열 압축 횟수
            String first_str = s.substring(0, i); //앞문자열
            String second_str = ""; //뒤문자열
            StringBuilder builder = new StringBuilder();//초기화

            for (int j=i; j < s.length(); j += i) {
                // 1. 문자열 n만큼씩 자른다
                if(j+i >= s.length()) { // 끝이면
                    second_str = s.substring(j, s.length());
                } else {
                    second_str = s.substring(j, j+i); //n개씩 비교할 뒷문자열
                }

                // 2. 문자열끼리 앞뒤로 같은지 비교한다
                if(first_str.equals(second_str)) {
                    //같으면 cnt증가
                    cnt++;
                } else if (cnt == 1) {
                        //다르면 cnt값만큼 builder에 저장
                        builder.append(first_str);
                        first_str = second_str; //앞문자열 변경
                } else {
                        builder.append(cnt).append(first_str);
                        cnt = 1; //초기화
                        first_str = second_str; //앞문자열 변경
                }

                // 3. 비교후 남은 문자열있는지 확인
                if (j + i >= s.length()) { // 끝이면
                    if(cnt == 1) builder.append(second_str);
                    else builder.append(cnt).append(second_str);
                }
            }
            // 4. 짧은 문자열 크기 저장
            answer = Math.min(answer, builder.length());
        }
        return answer;
    }

    public static void main(String[] args) {
            PG60057_문자열압축 t = new PG60057_문자열압축();
            String s1 = "aabbaccc";
            String s2 = "ababcdcdababcdcd";
            String s3 = "xababcdcdababcdcd";
        System.out.println(t.solution(s1));
        System.out.println(t.solution(s2));
        System.out.println(t.solution(s3));
    }
}
