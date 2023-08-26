import java.util.*;
class Solution {
    static int[] range = new int[200];
    
    public int solution(int[][] lines) {
        for (int i = 0; i < lines.length; i++) {
            for (int j = lines[i][0]; j < lines[i][1]; j++) {
                range[j+100] ++;
            }
        }
        return checkLines();
    }
    
    private int checkLines() {
        return (int) Arrays.stream(range)
                .filter(value -> value >= 2)
                .count();
    }
}