import java.util.*;
class Solution {
    public static int[] solution(int brown, int yellow) {
        // brown + yellow = row * col
        List<int[]> candidates = new ArrayList<>();
        int sum = brown + yellow;
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                candidates.add(new int[] {sum / i, i});
            }
        }
        for (int[] candidate : candidates) {
            int row = 0, i = 0;
            while (true) {
                row += (candidate[0] - i) * 2 + (candidate[1] - i - 2) * 2;
                if (row < 0 || row > brown) break;
                if (row == brown) return new int[] {candidate[0], candidate[1]};
                i++;
            }
        }
        return null;
    }
}