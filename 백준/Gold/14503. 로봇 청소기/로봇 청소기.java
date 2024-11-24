import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int cleaned = 0;
    static int[] addX = {-1, 0, 1, 0};
    static int[] addY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);
            map = new int[N][M];
            visited = new boolean[N][M];
            String[] input2 = br.readLine().split(" ");
            int r = Integer.parseInt(input2[0]);
            int c = Integer.parseInt(input2[1]);
            int d = Integer.parseInt(input2[2]);
            for (int i = 0; i < N; i++) {
                String[] data = br.readLine().split(" ");
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(data[j]);
                }
            }

            clean(r, c, d);
            System.out.println(cleaned);
        }
    }

    public static void clean(int r, int c, int d) {
        if (!visited[r][c]) {
            visited[r][c] = true;
            cleaned++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int newX = r + addX[d];
            int newY = c + addY[d];

            if (!visited[newX][newY] && map[newX][newY] == 0) {
                clean(newX, newY, d);
                return;
            }
        }

        int backDirection = (d + 2) % 4;
        int backX = r + addX[backDirection];
        int backY = c + addY[backDirection];

        if (map[backX][backY] == 0) {
            clean(backX, backY, d);
        }
    }
}
