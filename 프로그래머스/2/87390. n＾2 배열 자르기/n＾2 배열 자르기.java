import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        long startX = left / n;// 0
        long startY = left % n;// 2
        for (int i = 0; i < answer.length; i++) {
            if (startX >= startY) answer[i] = (int) (startX + 1);
            else if (startX < startY) answer[i] = (int) (startY + 1);

            if (startY == n - 1) {
                startX += 1;
                startY = 0;
            } else {
                startY += 1;
            }
        }
        return answer;
    }
}