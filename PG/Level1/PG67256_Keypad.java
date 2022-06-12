package PG.Level1;

public class PG67256_Keypad {


    public String solution(int[] numbers, String hand) {
        String answer = "";
        int leftLoc=10;
        int rightLoc=12;

        for (int number : numbers){
            if(number==1 || number==4 || number==7){
                leftLoc=number;
                answer+="L";
            }else if(number==3 || number==6 || number==9){
                rightLoc=number;
                answer+="R";

            }else {
                if(number==0) number+=11;
                int disLeft = (Math.abs(number-leftLoc))/3 + (Math.abs(number-leftLoc))%3;
                int disRight = (Math.abs(rightLoc-number))/3 + (Math.abs(rightLoc-number))%3;

                if(disLeft > disRight) {
                    answer+= "R";
                    rightLoc=number;
                }else if(disLeft < disRight){
                    answer+= "L";
                    leftLoc=number;
                }else {
                    if(hand.equals("right")) {
                        answer+= "R";
                        rightLoc=number;
                    }
                    else if(hand.equals("left")){
                        answer+= "L";
                        leftLoc=number;
                    }
                }

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PG67256_Keypad t = new PG67256_Keypad();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        System.out.println(t.solution(numbers, hand));
    }
}
