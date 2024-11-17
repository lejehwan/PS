import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    private static int N, K;
    private static int[][] thingsCandidate;
    private static int[] weights, values;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
//            thingsCandidate = new int[N + 1][2];
//            for (int i = 1; i <= N; i++) {
//                String[] data = br.readLine().split(" ");
//                thingsCandidate[i][0] = Integer.parseInt(data[0]);
//                thingsCandidate[i][1] = Integer.parseInt(data[1]);
//            }
//            System.out.println(knapsack_origin());

            weights = new int[N + 1];
            values = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                String[] data = br.readLine().split(" ");
                weights[i] = Integer.parseInt(data[0]);
                values[i] = Integer.parseInt(data[1]);
            }
            System.out.println(knapsack_oneDimensionArray());
        }
    }

    private static int knapsack_origin() {
        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                if (j < thingsCandidate[i][0]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - thingsCandidate[i][0]] + thingsCandidate[i][1]);
                }
            }
        }
        return dp[N][K];
    }

    private static int knapsack_oneDimensionArray() {
        int[] dp = new int[K + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = K; j >= weights[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weights[i]] + values[i]);
            }
        }
        return dp[K];
    }

}
