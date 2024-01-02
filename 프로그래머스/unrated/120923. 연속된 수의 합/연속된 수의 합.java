class Solution {
    public int[] solution(int num, int total) {
        if (total % num == 0) return remainderIsZero(num, total);
        else return remainderIsNotZero(num, total);
    }

    // 나머지가 0인 case
    private static int[] remainderIsZero(int num, int total) {
        int[] answer = new int[num];
        int midValue = total / num;
        int midIdx = num / 2;
        answer[midIdx] = midValue;
        for (int i = 1; i < midIdx + 1; i++) {
            answer[midIdx - i] = midValue - i;
            answer[midIdx + i] = midValue + i;
        }
        return answer;
    }

    // 나머지가 0이 아닌 case
    private static int[] remainderIsNotZero(int num, int total) {
        int[] answer = new int[num];
        int midValue = total / num;
        int midIdx = num / 2;
        for (int i = 1; i < midIdx + 1; i++) {
            answer[midIdx - i] = midValue - i + 1;
            answer[midIdx + i - 1] = midValue + i;
        }
        return answer;
    }
}