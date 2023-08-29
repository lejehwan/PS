class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] joka = {"aya", "ye", "woo", "ma"};
        for (int i = 0; i < babbling.length; i++) {
            int len = babbling[i].length();
            for (int j = 0; j < joka.length; j++) {
                if (babbling[i].contains(joka[j]) && len > 0){
                    len -= joka[j].length();
                }
            }
            if (len == 0) answer ++;
        }
        return answer;
    }
}