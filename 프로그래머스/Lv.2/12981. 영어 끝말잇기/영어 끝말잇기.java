import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) { 
        Set<String> set = new HashSet<>();
        set.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            set.add(words[i]);

            char lastWord = words[i - 1].toCharArray()[words[i - 1].length() - 1];
            char firstWord = words[i].toCharArray()[0];
            if (lastWord != firstWord || set.size() != i + 1) {
                return new int[] {i % n + 1, i / n + 1};
            }
        }
        return new int[] {0, 0};
    }
}