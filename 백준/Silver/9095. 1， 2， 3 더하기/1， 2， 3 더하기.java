import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

class Main {

    static int[] dp = new int[11];

    public static void main(String[] args) throws IOException {
        int[] tc = init();
//        String answer = dpBottomUp(tc);
        String answer = dpTopDown(tc);
        System.out.println(answer);
    }

    private static String dpTopDown(int[] tc) {
        Arrays.fill(dp, -1);
        return Arrays.stream(tc)
                .mapToObj(t -> String.valueOf(topDown(t)))
                .collect(Collectors.joining("\n"));
    }

    private static int topDown(int n) {
        if (dp[n] > 0) return dp[n];

        if (n == 1) return 1;
        if (n == 2) return 2;
        if (n == 3) return 4;

        dp[n] = topDown(n - 1) + topDown(n - 2) + topDown(n - 3);

        return dp[n];
    }

    private static String dpBottomUp(int[] tc) {
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return Arrays.stream(tc)
                .mapToObj(t -> String.valueOf(dp[t]))
                .collect(Collectors.joining("\n"));
    }

    private static int[] init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] tc = new int[T];
        for (int i = 0; i < T; i++) {
            tc[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        return tc;
    }


}
