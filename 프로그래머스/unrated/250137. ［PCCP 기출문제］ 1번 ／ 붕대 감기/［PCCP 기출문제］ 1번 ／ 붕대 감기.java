class Solution {
    public static int solution(int[] bandage, int health, int[][] attacks) {
        int maxHealth = health;
        int straight = 0;
        int attackIdx = 0;
        for (int i = 0; i <= attacks[attacks.length - 1][0]; i++) {

            // 공격을 받는 경우
            // 1. 죽는지 체크
            // 2. 연속 성공 횟수 초기화
            if (i == attacks[attackIdx][0]) {
                health -= attacks[attackIdx][1];
                if (checkDead(health)) return -1;
                straight = 0;
                attackIdx += 1;
            }
            // 공격을 받지 않는 경우
            // 1. 연속 성공 횟수 +1
            // 2. 연속 성공 횟수 달성 시
            // 2.1 추가 체력 회복
            // 2.2 연속 성공 횟수 초기화
            else {
                health += bandage[1];
                if (checkOverHealth(maxHealth, health)) health = maxHealth;
                straight += 1;

                // 연속 성공 한 경우
                if (bandage[0] == straight) {
                    health += bandage[2];
                    if (checkOverHealth(maxHealth, health)) health = maxHealth;
                    straight = 0;
                }
            }

        }
        return health;
    }
    
    // 최대 체력 넘기는지 확인
    private static boolean checkOverHealth(int maxHealth, int health) {
        return health > maxHealth;
    }

    // 죽는지 확인
    private static boolean checkDead(int health) {
        return health <= 0;
    }
}