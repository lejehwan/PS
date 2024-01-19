import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];
        // 시작 좌표 (x,y)
        int startX = (int) (left / n);
        int startY = (int) (left % n);
        for (int i = 0; i < answer.length; i++) {
            if (startX >= startY) answer[i] = startX + 1;
            else answer[i] = startY + 1;

            // 끝에 도달 시 좌표값 수정
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