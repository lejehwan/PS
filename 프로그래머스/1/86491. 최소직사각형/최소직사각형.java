import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0, maxHeight = 0;
        for (int[] size : sizes) {
            int width = Math.max(size[0], size[1]);
            int height = Math.min(size[0], size[1]);
            maxWidth = Math.max(maxWidth, width);
            maxHeight = Math.max(maxHeight, height);
        }
        return maxWidth * maxHeight;
    }
}