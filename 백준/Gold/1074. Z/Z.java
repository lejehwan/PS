import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static final int QUADRANT_1 = 0, QUADRANT_2 = 1, QUADRANT_3 = 2, QUADRANT_4 = 3;
    static int N, r, c = 0, cnt = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve(N, r, c);
        System.out.println(cnt);
    }

    private static void solve(int size, int x, int y) {
        if (size == 1) return;

        int calSize = size / 2;
        if (calSize > x && calSize > y) {
            cnt += calCnt(size, QUADRANT_1);
            solve(calSize, x, y);
        } else if (calSize > x) {
            cnt += calCnt(size, QUADRANT_2);
            solve(calSize, x, y - calSize);
        } else if (calSize > y) {
            cnt += calCnt(size, QUADRANT_3);
            solve(calSize, x - calSize, y);
        } else {
            cnt += calCnt(size, QUADRANT_4);
            solve(calSize, x - calSize, y - calSize);
        }
    }

    private static int calCnt(int size, int quadrant) {
        return (int) Math.pow(size, 2) / 4 * quadrant;
    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            N = (int) Math.pow(2, Integer.parseInt(data[0]));
            r = Integer.parseInt(data[1]);
            c = Integer.parseInt(data[2]);
        }
    }

}