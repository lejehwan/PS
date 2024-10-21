import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;

class Main {

    static int[][] rgb;

    public static void main(String[] args) throws IOException {
        init();
        int answer = dp();
        System.out.println(answer);
    }

    private static int dp() {
        int[][] dp = new int[rgb.length][rgb[0].length];
        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + rgb[i][0];
            dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + rgb[i][1];
            dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + rgb[i][2];
        }
        return min(min(dp[rgb.length - 1][0], dp[rgb.length - 1][1]), dp[rgb.length - 1][2]);
    }


    private static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            rgb = new int[N][3];
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                rgb[i][0] = Integer.parseInt(data[0]);
                rgb[i][1] = Integer.parseInt(data[1]);
                rgb[i][2] = Integer.parseInt(data[2]);
            }
        }
    }

}
