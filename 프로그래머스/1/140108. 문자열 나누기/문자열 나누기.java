import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] chars = s.toCharArray();
        char stand = 0;
        List<Character> firstStore = new ArrayList<>();
        List<Character> secondStore = new ArrayList<>();
        for (char ch : chars) {
            if (firstStore.isEmpty()) {
                stand = ch;
            }

            if (stand == ch) {
                firstStore.add(ch);
            } else {
                secondStore.add(ch);
            }

            if (firstStore.size() == secondStore.size()) {
                answer++;
                firstStore.clear();
                secondStore.clear();
            }
        }
        if (!firstStore.isEmpty()) answer ++;
        return answer;
    }
}