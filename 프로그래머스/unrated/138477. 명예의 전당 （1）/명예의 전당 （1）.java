import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            list.add(score[i]);
            Collections.sort(list);
            if (i >= k){
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < k; j++) {
                    temp.add(list.get(list.size() - j - 1));
                    Collections.sort(temp);
                }
                answer[i] = temp.get(0);
            }else answer[i] = list.get(0);
        }
        return answer;
    }
}
