package PG.Level1.basic;

/**
 * 풀이 날짜 : 2024/09/11
 * https://school.programmers.co.kr/learn/courses/30/lessons/250137
 */
public class PG250137_붕대감기 {

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0; // 현재 체력 1. 체력이 0이 될때 종료 2. 어택이 끝났을 때 종료

        // 시전시간
        int castingTime = bandage[0];
        // 회복량
        int healingAmount = bandage[1];
        // 추가 회복량
        int addHealingAmount = bandage[2];

        // 초기값 셋팅
        // 현재시간
        int currentTime = 0;
        // 연속 성공시간
        int successCount = 0;
        // 공격여부 ,(공격할 거리가 다 끝났는지)
        boolean isAttack = false;

        int maxHealth = health;
        int maxCastingTime = 50;


        while (health <= maxHealth) {
            currentTime ++;
            // 어택 당함
            for (int i=0; i < attacks.length; i++) {
                int attackTime =  attacks[i][0];
                int attackAmount = attacks[i][1];

                // 더이상 어택 당할게 없다면 종료
                if (i == attacks.length) {
                    break;
                }
//                 어택시간이 현재시간보다 이전이면 넘어감
                if (currentTime < attackTime) {
                    isAttack = false;
                    break;
                }

                // 어택시간과 현재시간이 같다면 어택
                if (currentTime == attackTime) {
                    health -= attackAmount;
                    successCount = 0;
                    isAttack = true;
                    break;
                }
            }
            // 어택을 받은 경우 다음 날로 넘어감
            if(isAttack) {
                continue;
            }

            if (health + 1 > maxHealth) {
                System.out.println("최대 체력 이상의 체력을 가질 수 없습니다.");
                continue;
            } else {
                health += healingAmount;
            }


            // 시전시간 도래시 추가회복
            if (successCount == castingTime) {
                if (health + 1 > maxHealth) {
                    System.out.println("최대 체력 이상의 체력을 가질 수 없습니다.");
                    continue;
                }
                health +=  addHealingAmount;
                successCount = 0;
            }
            else if(successCount > maxCastingTime) {
                successCount++;
                break;
            }

            successCount++;

            if( health == 0 ) {
                answer = 0;
                break;
            }

        }

        return answer;
    }


   // 해결한 방법
// bandage[0] [시전 시간, 초당 회복량, 추가 회복량]
    public static int solution02(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int maxHealth = health; // 최대 회복량
        int curHealth = health; // 현재 회복량
        int cnt = 0; // 연속 성공수
        int attackIdx = 0;
        int curIdx = 0; // 현재시간
        int attackCnt = attacks.length - 1; // 어택할 횟수



        while(true){
            curIdx++;  // 현재시간
            /**
             * 어택 있는 지 체크 --> 이 부분에서 어택할 이차원배열을 반복해서 체크하는 반복문 사용했음
             *  반복문이 아니라 현재시간과 같으면  attackIdx를 횟수를 증가시키고
             *  가장 마지막 어택시간이면 종료로 끝낸다
             */
            if(attacks[attackIdx][0] == curIdx){ // 현재시간이 어택시간이라면
                cnt = 0; // 연속 성공 0 리셋
                curHealth -= attacks[attackIdx][1]; // 현재 회복량에서 어택한 체력 감소
                if(curHealth <= 0){ // 체력이 없으면 -1 리턴
                    answer = -1;
                    break;
                }else{
                    // 체력이 있다면
                    // 가장 마지막 어택한 시간이면 종료
                    if(attackCnt == attackIdx){
                        answer = curHealth;
                        break;
                    }
                    // 어택 인덱스가 지나면 횟수증가
                    attackIdx++;
                    continue;
                }
            }

            cnt++; // 어택받지 않고 지나면 성공으로 간주 -> 횟수 증가
            if(cnt < bandage[0]){ // 시전 시간보다 작으면  보통시간으로 증가
                curHealth += bandage[1];
            }else{ // 시전시간이 지나면 추가시간으로 증가
                curHealth += (bandage[1] + bandage[2]);
                cnt = 0;
            }
            // 현재시간이 최대시간보다 크면 최대시간으로 변경
            // 현재시간이 최대시간보다 작거나 같으면 현재시간으로 변경
            curHealth = curHealth > maxHealth ? maxHealth : curHealth;
        }

        return answer;
    }


    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        solution02(bandage, health, attacks);

    }
}
