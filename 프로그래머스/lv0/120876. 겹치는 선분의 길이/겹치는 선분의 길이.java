import java.util.*;
class Solution {
    static int[] range = new int[200];
    
    public int solution(int[][] lines) {
        for (int[] line : lines) {
            for (int j = line[0]; j < line[1]; j++) {
                range[j + 100]++;
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