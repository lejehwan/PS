class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] array = new int[number];
        for (int i = 1; i <= number; i++) {
            array[i - 1] = getDivisor(i);
        }
        for (int value : array) {
            if (value > limit) answer += power;
            else answer += value;
        }
        return answer;
    }
        private static int getDivisor(int number){
        int divisor = 0;
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0){
                divisor ++;
                if (number / i != i) divisor ++;
            }
        }
        return divisor;
    }
}