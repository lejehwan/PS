import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 0);
        int conCnt = 1;
        for (int i = 1; i < words.length; i++) {
            if (i % n == 0) conCnt ++;

            char lastWord = words[i - 1].toCharArray()[words[i - 1].length() - 1];
            char firstWord = words[i].toCharArray()[0];
            if (lastWord != firstWord || map.containsKey(words[i])) {
                System.out.println(words[i]);
                int num = (i + 1) % n == 0 ? n : (i + 1) % n;
                return new int[] {num, conCnt};
            }

            map.put(words[i], 0);
        }
        return new int[] {0, 0};
    }
}