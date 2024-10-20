import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    static int[] data, dp;

    public static void main(String[] args) throws IOException {
        init();
        int answer = dp();
        System.out.println(answer);
    }

    private static int dp() {
        dp = new int[data.length];
        Arrays.fill(dp, 1);

        int answer = 1;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < i; j++) {
                if (data[i] > data[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    private static void init() throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            data = new int[N];
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < input.length; i++) {
                data[i] = Integer.parseInt(input[i]);
            }
        }
    }

}
