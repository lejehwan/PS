import java.util.*;
public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack stack = new Stack();
        stack.add(arr[0]);
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if ((int)stack.peek() != arr[i]) list.add(arr[i]);
            stack.add(arr[i]);
        }
        
        return list.stream()
            .mapToInt(i->i)
            .toArray();
    }
}