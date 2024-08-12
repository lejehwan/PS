import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static final int[] ADD_X = {1, -1, 0, 0};
    private static final int[] ADD_Y = {0, 0, 1, -1};
    private static int[][] map;
    private static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();
        exhaustiveSearch();
        printAnswer();
    }

    private static void printAnswer() {
        int answer = 0;
        for (int[] ints : map) {
            for (int j = 0; j < map[0].length; j++) {
                if (ints[j] == 0) {
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, ints[j]);
            }
        }
        System.out.println(answer - 1);
    }

    private static void exhaustiveSearch() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        bfs();
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < ADD_X.length; i++) {
                int newX = getX + ADD_X[i];
                int newY = getY + ADD_Y[i];
                if (isValidMapSize(newX, newY) && map[newX][newY] == 0) {
                    queue.add(new int[] {newX, newY});
                    map[newX][newY] = map[getX][getY] + 1;
                }
            }
        }
    }

    private static boolean isValidMapSize(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length;
    }


    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        map = new int[Integer.parseInt(input[1])][Integer.parseInt(input[0])];
        for (int i = 0; i < map.length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
