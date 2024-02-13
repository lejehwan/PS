import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.merge(player, 1, Integer::sum);
        }
        for (String player : completion) {
            map.merge(player, 1, (v1, v2) -> v1 - 1);
        }
        for (String player : map.keySet()) {
            if (map.get(player) != 0) return player;
        }
        return "";
    }
}