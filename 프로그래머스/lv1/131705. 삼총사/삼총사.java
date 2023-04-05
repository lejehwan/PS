class Solution {
    public int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            int sum = number[i];
            for (int j = i + 1; j < number.length; j++) {
                sum += number[j];
                for (int k = j + 1; k < number.length; k++) {
                    if (sum + number[k] == 0) answer ++;
                }
                sum -= number[j];
            }
            sum -= number[i];
        }
        return answer;
    }
}