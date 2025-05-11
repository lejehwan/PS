import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] tanghuru = new int[N];
            for (int i = 0; i < tanghuru.length; i++) {
                tanghuru[i] = Integer.parseInt(input[i]);
            }
            twoPointers(tanghuru);
        }
    }

    private static void twoPointers(int[] tanghuru) {
        int[] cnt = new int[10];
        int left = 0, right = 0, maxLen = 0, kind = 0;

        while (right < tanghuru.length) {
            if (cnt[tanghuru[right]] == 0) kind ++;
            cnt[tanghuru[right]] ++;
            right ++;

            while (kind > 2) {
                cnt[tanghuru[left]] --;
                if (cnt[tanghuru[left]] == 0) kind --;
                left ++;
            }

            maxLen = Math.max(maxLen, right - left);
        }
        System.out.println(maxLen);
    }
}
