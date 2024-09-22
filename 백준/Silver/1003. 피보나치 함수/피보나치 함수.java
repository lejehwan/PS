import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int MAX = 40;
    static int[][] dp = new int[MAX + 1][2];

    public static void main(String[] args) throws IOException {
        int[] tc = init();
        topDown(tc);
//        bottomUp(tc);
    }

    private static void bottomUp(int[] tc) {
        dpBottomUp();
        for (int N : tc) {
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    private static void topDown(int[] tc) {
        topDownInit();
        for (int N : tc) {
            dpTopDown(N);
            System.out.println(dp[N][0] + " " + dp[N][1]);
        }
    }

    private static void topDownInit() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
    }

    private static void dpBottomUp() {
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }

    private static int[] dpTopDown(int N) {
        if (dp[N][0] == -1 || dp[N][1] == -1) {
            dp[N][0] = dpTopDown(N - 1)[0] + dpTopDown(N - 2)[0];
            dp[N][1] = dpTopDown(N - 1)[1] + dpTopDown(N - 2)[1];
        }
        return dp[N];
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
