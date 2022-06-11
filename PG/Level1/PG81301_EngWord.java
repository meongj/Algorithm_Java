package PG.Level1;

public class PG81301_EngWord {
    public int solution(String s) {
        String[] num = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};

        for (int i=0; i<num.length; i++){
            s = s.replace(num[i], Integer.toString(i));
        }

        return Integer.parseInt(s);
    }

    public static void main(String[] args) {
        PG81301_EngWord t = new PG81301_EngWord();
        String word = "one4seveneight";

        System.out.println(t.solution(word));
    }
}
