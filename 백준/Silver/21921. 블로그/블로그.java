import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int[] visits = new int[N];
            input = br.readLine().split(" ");
            for (int i = 0; i < visits.length; i++) {
                visits[i] = Integer.parseInt(input[i]);
            }
            slidingWindow(X, visits);
        }
    }

    private static void slidingWindow(int section, int[] visits) {
        int crtSum = 0;
        int cnt = 1;
        for (int i = 0; i < section; i++) {
            crtSum += visits[i];
        }

        int maxSum = crtSum;
        for (int i = section; i < visits.length; i++) {
            crtSum = crtSum - visits[i - section] + visits[i];

            if (crtSum > maxSum) {
                maxSum = crtSum;
                cnt = 1;
            } else if (crtSum == maxSum) {
                cnt ++;
            }
        }

        if (maxSum == 0) System.out.println("SAD");
        else System.out.printf("%d\n%d\n", maxSum, cnt);
    }
}
