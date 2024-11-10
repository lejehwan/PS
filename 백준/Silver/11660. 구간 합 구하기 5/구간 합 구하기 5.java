import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            int N = Integer.parseInt(data[0]);
            int M = Integer.parseInt(data[1]);
            int[][] dp = new int[N + 1][N + 1];
            for (int i = 1; i < dp.length; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j] + Integer.parseInt(input[j - 1]) - dp[i - 1][j - 1];
                }
            }

            for (int i = 0; i < M; i++) {
                String[] input = br.readLine().split(" ");
                sb.append(
                        sum(dp,
                                Integer.parseInt(input[0]),
                                Integer.parseInt(input[1]),
                                Integer.parseInt(input[2]),
                                Integer.parseInt(input[3]))
                        ).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static int sum(int[][] dp, int x1, int y1, int x2, int y2) {
        return dp[x2][y2] - (dp[x1 - 1][y2] + dp[x2][y1 - 1]) + dp[x1 - 1][y1 - 1];
    }

}
