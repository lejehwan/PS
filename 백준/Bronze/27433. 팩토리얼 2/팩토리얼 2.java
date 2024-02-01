import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(factorial(n));
    }

    private static long factorial(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

}