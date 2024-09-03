import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int m = 0;

    public static void main(String[] args) throws Exception {
        int[] data = prefixSum();
        getRangeSum(data);
        closeStream();
    }

    private static void closeStream() throws Exception{
        br.close();
    }

    private static void getRangeSum(int[] data) throws Exception{
        for (int i = 0; i < m; i++) {
            String[] input = getInputData();
            int sum = data[Integer.parseInt(input[1])] - data[Integer.parseInt(input[0]) - 1];
            System.out.println(sum);
        }
    }

    private static int[] prefixSum() throws Exception{
        String[] input = getInputData();
        int n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int[] data = new int[n + 1];
        input = getInputData();
        for (int i = 1; i < data.length; i++) {
            data[i] = Integer.parseInt(input[i - 1]) + data[i - 1];
        }
        return data;
    }

    private static String[] getInputData() throws Exception{
        return br.readLine().split(" ");
    }
}
