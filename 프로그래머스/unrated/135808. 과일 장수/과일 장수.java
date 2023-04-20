import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for (int value : score) {
            list.add(value);
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i = 1; i <= list.size(); i++) {
            if (i % m == 0) {
                answer += list.get(i - 1) * m;
            }
        }
        return answer;
    }
}