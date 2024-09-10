import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static int[][] map;
    static int whiteC = 0, blueC = 0;

    public static void main(String[] args) throws IOException {
        init();
        divide(map, 0, 0, map.length);
        printAnswer();
    }

    private static void printAnswer() {
        System.out.println(whiteC);
        System.out.println(blueC);
    }

    private static void divide(int[][] map, int x, int y, int size) {
        if (canCompress(map, x, y, size)) {
            if (map[x][y] == 0) whiteC ++;
            if (map[x][y] == 1) blueC ++;
            return;
        }

        divide(map, x + size / 2, y, size / 2);
        divide(map, x, y + size / 2, size / 2);
        divide(map, x + size / 2, y + size / 2, size / 2);
        divide(map, x, y, size / 2);
    }

    private static boolean canCompress(int[][] map, int x, int y, int size) {
        int standardVal = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (map[i][j] != standardVal) return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(data[j]);
            }
        }
        br.close();
    }


}