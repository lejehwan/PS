import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int tc = Integer.parseInt(br.readLine());
            for (int i = 0; i < tc; i++) {
                int n = Integer.parseInt(br.readLine());
                int[][] sticker = new int[2][n];
                for (int j = 0; j < sticker.length; j++) {
                    String[] input = br.readLine().split(" ");
                    for (int k = 0; k < input.length; k++) {
                        sticker[j][k] = Integer.parseInt(input[k]);
                    }
                }

                sb.append(dp(sticker)).append("\n");
            }
            System.out.println(sb);
        }
    }

    private static int dp(int[][] sticker) {
        int[][] dp = new int[sticker.length][sticker[0].length];
        dp[0][0] = sticker[0][0];
        dp[1][0] = sticker[1][0];
        
        if (dp[0].length == 1) return Math.max(dp[0][0], dp[1][0]);

        dp[0][1] = sticker[1][0] + sticker[0][1];
        dp[1][1] = sticker[0][0] + sticker[1][1];

        for (int i = 2; i < dp[0].length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + sticker[0][i];
            dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + sticker[1][i];
        }

        return Math.max(dp[0][dp[0].length - 1], dp[1][dp[0].length - 1]);
    }


}
