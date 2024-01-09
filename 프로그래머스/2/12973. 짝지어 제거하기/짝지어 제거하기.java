import java.util.*;
class Solution
{
    public int solution(String s)
    {
        if (s.length() % 2 != 0) return 0;

        Stack<Character> stack = new Stack<>();
        char[] charArr = s.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (stack.isEmpty()) {
                stack.push(charArr[i]);
                continue;
            }
            if (stack.peek() != charArr[i]) {
                stack.push(charArr[i]);
            } else {
                stack.pop();
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}