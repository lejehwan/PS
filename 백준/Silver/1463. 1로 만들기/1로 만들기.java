import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        int N = init();
        int answer = dpBottomUp(N);
//        int answer = dpTopDown(N);
        System.out.println(answer);
    }

    // private static int dpTopDown(int n) {
    //     if (n == 1) return 0;
    //     if (dp[n] > 0) return dp[n];

    //     dp[n] = dpTopDown(n - 1) + 1;
    //     if (n % 3 == 0) dp[n] = Math.min(dp[n], dpTopDown(n / 3) + 1);
    //     if (n % 2 == 0) dp[n] = Math.min(dp[n], dpTopDown(n / 2) + 1);
    //     return dp[n];
    // }

    private static int dpBottomUp(int n) {
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
        }
        return dp[n];
    }


    private static int init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        br.close();
        return N;
    }


}
