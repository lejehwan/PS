import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int[][] map;
    static boolean[][] visited;
    static int[] startVertex;
    static final int[] ADD_ROW = new int[] {1, -1, 0, 0};
    static final int[] ADD_COL = new int[] {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        printAnswer();
    }

    private static void printAnswer() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(startVertex);
        visited[startVertex[0]][startVertex[1]] = true;

        while (!queue.isEmpty()) {
            int getX = queue.peek()[0];
            int getY = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < ADD_ROW.length; i++) {
                int newX = getX + ADD_ROW[i];
                int newY = getY + ADD_COL[i];
                if (isValidMapSize(newX, newY) && !visited[newX][newY] && map[newX][newY] == 1) {
                    queue.add(new int[] {newX, newY});
                    visited[newX][newY] = true;
                    map[newX][newY] = map[getX][getY] + 1;
                }
            }
        }
    }

    private static boolean isValidMapSize(int newX, int newY) {
        return newX >= 0 && newX < map.length && newY >= 0 && newY < map[0].length;
    }

    private static void init() throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] data = br.readLine().split(" ");
            map = new int[Integer.parseInt(data[0])][Integer.parseInt(data[1])];
            visited = new boolean[map.length][map[0].length];
            for (int i = 0; i < map.length; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < map[0].length; j++) {
                    int temp = Integer.parseInt(input[j]);
                    if (temp == 2) {
                        startVertex = new int[] {i, j};
                        continue;
                    }
                    map[i][j] = temp;
                }
            }
        }
    }

}