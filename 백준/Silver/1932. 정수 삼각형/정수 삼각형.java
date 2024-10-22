import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;

class Main {

    static int[][] trig;

    public static void main(String[] args) throws IOException {
        init();
        int answer = dp();
        System.out.println(answer);
    }

    private static int dp() {
        int[][] dp = new int[trig.length][trig.length];
        dp[0][0] = trig[0][0];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j];
                else if (i == j) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] += trig[i][j];
            }
        }
        
        int answer = dp[dp.length - 1][0];
        for (int i = 1; i < dp[0].length; i++) {
            answer = max(answer, dp[dp.length - 1][i]);
        }
        return answer;
    }


    private static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            trig = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for (int j = 0; j < data.length; j++) {
                    trig[i][j] = Integer.parseInt(data[j]);
                }
            }
        }
    }

}
