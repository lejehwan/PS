import java.io.*;
import java.util.*;

public class Main {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> sequence = new ArrayList<>();
            while (st.hasMoreElements()) {
                int seq = Integer.parseInt(st.nextToken());
                if (seq != 0) sequence.add(seq);
            }

            int[][][] dp = new int[sequence.size() + 1][5][5];
            for (int[][] matrix : dp) {
                for (int[] row : matrix) {
                    Arrays.fill(row, INF);
                }
            }
            dp[0][0][0] = 0;

            for (int i = 0; i < dp.length - 1; i++) {
                int move = sequence.get(i);
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (dp[i][j][k] == INF) continue;

                        int curtCost = dp[i][j][k];
                        // 오른발
                        if (move != j) dp[i + 1][j][move] = Math.min(dp[i + 1][j][move], curtCost + cost(k, move));
                        // 왼발
                        if (move != k) dp[i + 1][move][k] = Math.min(dp[i + 1][move][k], curtCost + cost(j, move));
                    }
                }
            }

            int answer = INF;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    answer = Math.min(answer, dp[dp.length - 1][i][j]);
                }
            }

            System.out.println(answer);
        }
    }

    private static int cost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if ((from == 1 && to == 3) || (from == 3 && to == 1)
                || (from == 2 && to == 4) || (from == 4 && to == 2))
            return 4;

        return 3;
    }


}
