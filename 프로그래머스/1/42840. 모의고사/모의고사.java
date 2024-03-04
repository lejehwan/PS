import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        final int[] peo1 = new int [] {1, 2, 3, 4, 5};
        final int[] peo2 = new int [] {2, 1, 2, 3, 2, 4, 2, 5};
        final int[] peo3 = new int [] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int peo1Val = 0, peo2Val = 0, peo3Val = 0;
        for (int i = 0; i < answers.length; i ++) {
            if (peo1[i % peo1.length] == answers[i]) peo1Val ++;
            if (peo2[i % peo2.length] == answers[i]) peo2Val ++;
            if (peo3[i % peo3.length] == answers[i]) peo3Val ++;
        }
        
        int maxVal = Math.max(peo1Val, Math.max(peo2Val, peo3Val));
        ArrayList<Integer> list = new ArrayList<>();
        if (peo1Val == maxVal) list.add(1);
        if (peo2Val == maxVal) list.add(2);
        if (peo3Val == maxVal) list.add(3);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i ++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}