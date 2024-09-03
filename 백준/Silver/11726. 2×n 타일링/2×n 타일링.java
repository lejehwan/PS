import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int DIVISOR = 10007;

    public static void main(String[] args) throws Exception {
        int n = getInputData();
        getTile(n);
        closeStream();
    }

    private static void getTile(int n) {
        int[] data = new int[1001];
        data[1] = 1;
        data[2] = 2;
        for (int i = 3; i <= n; i++) {
            data[i] = (data[i - 1] + data[i - 2]) % DIVISOR;
        }
        System.out.println(data[n]);
    }

    private static void closeStream() throws Exception{
        br.close();
    }

    private static int getInputData() throws Exception{
        return Integer.parseInt(br.readLine());
    }

}
