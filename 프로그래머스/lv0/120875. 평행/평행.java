class Solution {
    public int solution(int[][] dots) {
        float firstSlope, secondSlope;

        firstSlope = (float)(dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]);
        secondSlope = (float)(dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0]);
        if (firstSlope == secondSlope) return 1;

        firstSlope = (float)(dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]);
        secondSlope = (float)(dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0]);
        if (firstSlope == secondSlope) return 1;

        firstSlope = (float)(dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]);
        secondSlope = (float)(dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]);
        if (firstSlope == secondSlope) return 1;
        return 0;
    }
}