import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


class Main {

    static int[] trees;
    static int M;

    public static void main(String[] args) throws IOException {
        init();
        long answer = binarySearch();
        printAnswer(answer);
    }

    private static void printAnswer(long answer) {
        System.out.println(answer);
    }

    private static long binarySearch() {
        int low = 1;
        int high = trees[trees.length -  1];
        int result = 0;
        while(low <= high) {
            int mid = (low + high) / 2;
            long sum = 0;
            for (int tree : trees) {
                sum += Math.max(tree - mid, 0);
            }
            if (sum >= M) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        trees = new int[N];
        String[] data = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(data[i]);
        }
        Arrays.sort(trees);
        br.close();
    }


}