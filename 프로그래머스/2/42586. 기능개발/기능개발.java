import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = speeds.length - 1; i >= 0; i --) {
            int revise = 0;
            if((100 - progresses[i]) % speeds[i] != 0) revise ++;
            stack.add((100 - progresses[i]) /speeds[i] + revise);
        }
        
        int av = 1;
        int standard = stack.pop();
        while(!stack.isEmpty()) {
            int value = stack.pop();
            if (value <= standard) av++;
            else {
                list.add(av);
                av = 1;
                standard = value;
            }
        }
        list.add(av);
        return list.stream()
            .mapToInt(i->i)
            .toArray();
    }
}