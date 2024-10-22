import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.Math.*;

class Main {

    static int[][] triangle;

    public static void main(String[] args) throws IOException {
        init();
        int answer = dp();
        System.out.println(answer);
    }

    /**
     * 맨 밑줄부터 차례로 더해 올라가서 마지막에 남은 최댓값을 반환한다.
     * @see #dp() 풀이에서 마지막에 따로 반복문을 통해 최댓값을 찾지 않아도 됨.
     * @return
     */
    private static int otherSolve() {
        for (int i = triangle.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                triangle[i - 1][j] += Math.max(triangle[i][j], triangle[i][j + 1]);
            }
        }
        return triangle[0][0];
    }

    private static int dp() {
        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) dp[i][j] = dp[i - 1][j];
                else if (i == j) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]);
                dp[i][j] += triangle[i][j];
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
            triangle = new int[N][N];
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for (int j = 0; j < data.length; j++) {
                    triangle[i][j] = Integer.parseInt(data[j]);
                }
            }
        }
    }

}
