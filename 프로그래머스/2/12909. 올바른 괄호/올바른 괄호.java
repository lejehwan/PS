import java.util.*;
class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (stack.isEmpty() && ch == ')') return false;
            
            if (ch == '(') stack.add('(');
            else if (ch == ')') stack.pop();
        }
    
        if (stack.isEmpty()) return true;
        return false;
    }
}