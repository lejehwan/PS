import java.util.*;
class Solution
{
    public int solution(String s)
    {
        if (s.length() % 2 != 0) return 0;

        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (char ch : charArr) {
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if (stack.peek() != ch) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}