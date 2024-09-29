import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static final int[] ADD_ROW = new int[] {-1, 1, 0, 0};
    static final int[] ADD_COL = new int[] {0, 0, -1, 1};
    static final int RIPE = 1;
    static final int NOT_RIPE = 0;
    static final int EMPTY = -1;
    static int[][] box;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        int answer = getTomatoStatus();
        System.out.println(answer);
    }

    private static int getTomatoStatus() {
        int answer = 0;
        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                if (box[i][j] == 0) return EMPTY;
                answer = Math.max(answer, box[i][j]);
            }
        }
        return answer - 1;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < ADD_ROW.length; i++) {
                int newX = getX + ADD_ROW[i];
                int newY = getY + ADD_COL[i];
                if (isValidBoxSize(newX, newY) && box[newX][newY] == NOT_RIPE) {
                    queue.add(new int[] {newX, newY});
                    box[newX][newY] = box[getX][getY] + 1;
                }
            }
        }
    }

    private static boolean isValidBoxSize(int x, int y) {
        return x >= 0 && x < box.length && y >= 0 && y < box[0].length;
    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            int M = Integer.parseInt(data[0]);
            int N = Integer.parseInt(data[1]);
            box = new int[N][M];
            for (int i = 0; i < box.length; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < box[0].length; j++) {
                    int temp = Integer.parseInt(input[j]);
                    if (temp == RIPE) queue.add(new int[] {i, j});
                    box[i][j] = temp;
                }
            }
        }
    }

}