import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queueCards1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queueCards2 = new LinkedList<>(Arrays.asList(cards2));

        for (String target : goal) {
            if (!queueCards1.isEmpty() && queueCards1.peek().equals(target)) {
                queueCards1.poll();
            } else if (!queueCards2.isEmpty() && queueCards2.peek().equals(target)) {
                queueCards2.poll();
            } else return "No";
        }
        return "Yes";
    }
}