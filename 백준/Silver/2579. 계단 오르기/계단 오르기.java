import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        int[] step = init();
        int answer = dpBottomUp(step);
        System.out.println(answer);
    }

    private static int dpBottomUp(int[] step) {
        int[] dp = new int[step.length];
        dp[1] = step[1];
        if (step.length > 2) dp[2] = step[1] + step[2];

        for (int i = 3; i < step.length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
        }
        return dp[step.length - 1];
    }


    private static int[] init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] step = new int[n + 1];
        for (int i = 1; i < step.length; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        br.close();
        return step;
    }


}