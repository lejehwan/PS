class Solution {
    public String solution(int[] food) {
        String answer = "";
        String temp = "";
        for (int i = 1; i < food.length; i++) {
            if (food[i] == 1) continue;
            for (int j = 0; j < food[i] / 2; j++) {
                temp += i;
            }
        }
        answer += temp + 0;
        String[] str = temp.split("");
        for (int i = str.length - 1; i >= 0; i--) {
            answer += str[i];
        }
        return answer;
    }
}