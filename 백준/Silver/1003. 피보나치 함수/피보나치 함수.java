import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int MAX = 40;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        int[] tc = init();
        memoization();
        for (int N : tc) {
            printAnswer(N);
        }
    }

    private static void memoization() {
        dp = new int[MAX + 1][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }
    }

    private static void printAnswer(int N) {
        System.out.println(dp[N][0] + " " + dp[N][1]);
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