class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].contains("ayaaya") | babbling[i].contains("yeye") |
                    babbling[i].contains("woowoo") | babbling[i].contains("mama")) continue;
            for (int j = 0; j < words.length; j++) {
                if (babbling[i].contains(words[j])){
                    babbling[i] = babbling[i].replace(words[j], " ");
                }
            }
            if (babbling[i].replace(" ","").length() == 0) answer ++;
        }
        return answer;
    }
}