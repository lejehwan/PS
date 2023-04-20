import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String[] str = s.split("");
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length; i++) {
            if (map.containsKey(str[i])){
                int temp = i - map.get(str[i]);
                map.replace(str[i], i);
                answer[i] = temp;
            }else {
                map.put(str[i], i);
                answer[i] = -1;
            }
        }
        return answer;
    }
}